import { CommonModule } from '@angular/common';
import { ChangeDetectionStrategy, Component, Injector, OnDestroy, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { RouterModule, RouterOutlet } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { User } from '../../core/models/user.model';
import { UserService } from '../../core/services/user.service';
import { UtilComponent } from '../../shared/components/util/util.component';
import { SharedModule } from '../../shared/shared.module';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterOutlet,
    RouterModule,
    SharedModule,
  ],
  templateUrl: './home.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class HomeComponent extends UtilComponent implements OnInit, OnDestroy {

  public usernameControl: FormControl;

  public isUser$: BehaviorSubject<boolean> = new BehaviorSubject(false);

  constructor(
    private userService: UserService,
    private fb: FormBuilder,
    injector: Injector
  ) {
    super(injector);
  }

  ngOnInit() {
    this.createUsernameControl();
    this.handleUserData();
  }

  ngOnDestroy(): void {
    this.isUser$.unsubscribe();
  }

  public onUsernameSubmit(): void {
    if (this.usernameControl.valid) {
      this.userService.isUser() ? this.updateUser() : this.createUser();
    } else {
      this.snack.info('Nome de usuário inválido');
    }
  }

  private createUser(): void {
    this.loading.start();
    this.userService.create(this.usernameControl.value).subscribe({
      next: (user: User) => {
        this.userService.persistUser(user?.id);
        this.isUser$.next(true);
        this.loading.stop();
      },
      error: (error) => this.handleError(error),
    });
  }

  private updateUser(): void {
    this.loading.start();
    this.userService.update(this.usernameControl.value).subscribe({
      next: () => this.loading.stop(),
      error: (error) => {
        this.handleError(error);
        this.userService.clearUserId();
      },
    });
  }

  private createUsernameControl(): void {
    this.usernameControl = this.fb.control('', [
      Validators.required,
      Validators.maxLength(20),
    ]);
  }

  private handleUserData(): void {
    if (this.userService.isUser()) {
      this.loading.start();
      this.userService.read().subscribe({
        next: (user) => {
          this.usernameControl.setValue(user?.name);
          this.isUser$.next(true);
          this.loading.stop();
        },
        error: () => {
          this.userService.clearUserId();
          this.loading.stop();
        },
      });
    }
  }
}
