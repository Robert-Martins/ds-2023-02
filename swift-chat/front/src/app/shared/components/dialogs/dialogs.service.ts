import { Injectable, OnDestroy, Type } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { DialogComponentData, DialogOptions } from './dialog.types';

@Injectable({
  providedIn: 'root'
})
export class DialogsService implements OnDestroy {

  public open$: BehaviorSubject<boolean> = new BehaviorSubject(false);

  public dialogComponentData$: BehaviorSubject<DialogComponentData> = new BehaviorSubject(null);

  private onClose: <T> (arg: T) => void; 

  constructor() { }

  ngOnDestroy(): void {
    this.open$.unsubscribe();
    this.dialogComponentData$.unsubscribe();
  }

  public open(dialog: Type<any>, options?: DialogOptions): void {
    this.dialogComponentData$.next(
      {
        component: dialog,
        inputs: options?.inputs ?? null
      }
    );
    this.onClose = options?.onClose ?? null;
    this.open$.next(true);
  }

  public close<T>(val?: T): void {
    if(val && this.onClose)
      this.onClose(val);
    this.onClose = null;
    this.open$.next(false);
  }

}
