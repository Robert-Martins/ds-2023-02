import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Snack } from './snackbar.types';

@Injectable({
  providedIn: 'root',
})
export class SnackbarService {
  public snack$: BehaviorSubject<Snack> = new BehaviorSubject<Snack>(null);

  public onSnackAssign: () => void;

  private snacks: Snack[] = [];

  private snackTimeout: number = 6200;

  public success(message: string): void {
    this.processSnackMessage(new Snack(message, 'SUCCESS'));
  }

  public info(message: string): void {
    this.processSnackMessage(new Snack(message, 'INFO'));
  }

  public error(message: string): void {
    this.processSnackMessage(new Snack(message, 'ERROR'));
  }

  private processSnackMessage(snack: Snack): void {
    this.snacks.push(snack);
    if (this.snacks.length === 1) this.handleSnackAssign(snack);
  }

  private handleSnackMessageFlow = (): void => {
    this.snacks = this.snacks.filter(
      (snack) => !snack.equals(this.snack$.value)
    );
    this.snack$.next(null);
    if (this.snacks.length > 0) this.handleSnackAssign(this.snacks.shift());
  };

  private handleSnackAssign(snack: Snack): void {
    this.snack$.next(snack);
    if (this.onSnackAssign) this.onSnackAssign();
    setTimeout(this.handleSnackMessageFlow, this.snackTimeout);
  }
}
