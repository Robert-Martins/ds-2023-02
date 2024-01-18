import { Component, Injectable, Injector } from '@angular/core';
import { SnackbarService } from '../snackbar/snackbar.service';
import { LoadingService } from '../splash-screen/loading.service';
import { DialogsService } from '../dialogs/dialogs.service';

@Injectable()
export abstract class UtilComponent {

  protected snack: SnackbarService;
  protected loading: LoadingService;
  protected dialog: DialogsService;

  constructor(
    injector: Injector
  ) {
    this.snack = injector.get(SnackbarService);
    this.loading = injector.get(LoadingService);
    this.dialog = injector.get(DialogsService);
  }

}
