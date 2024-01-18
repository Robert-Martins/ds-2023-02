import { CommonModule } from '@angular/common';
import { Component, Injector, OnInit } from '@angular/core';
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
  styleUrl: './home.component.css',
})
export class HomeComponent extends UtilComponent implements OnInit {
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

  public onUsernameInputBlur(): void {
    if (this.usernameControl.valid) {
      this.loading.start();
      this.userService.create(this.usernameControl.value).subscribe({
        next: (user: User) => {
          this.userService.persistUser(user?.id);
          this.isUser$.next(true);
          this.loading.stop();
        },
        error: (error) => {
          this.snack.error(error?.message);
          this.loading.stop();
        },
      });
    } else {
      this.snack.info('Nome de usuário inválido');
    }
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
        error: (error) => {
          this.snack.error(error?.message);
          this.loading.stop();
        },
      });
    }
  }
}
