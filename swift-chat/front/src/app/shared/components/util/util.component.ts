import { Injectable, Injector } from '@angular/core';
import { Router } from '@angular/router';
import { DialogsService } from '../dialogs/dialogs.service';
import { SnackbarService } from '../snackbar/snackbar.service';
import { LoadingService } from '../splash-screen/loading.service';

@Injectable()
export abstract class UtilComponent {
  protected snack: SnackbarService;
  protected loading: LoadingService;
  protected dialog: DialogsService;
  protected router: Router;

  constructor(injector: Injector) {
    this.snack = injector.get(SnackbarService);
    this.loading = injector.get(LoadingService);
    this.dialog = injector.get(DialogsService);
    this.router = injector.get(Router);
  }

  public onLoadChatError(): void {
    this.snack.info('Você será redirecionado para a Home');
    this.loading.stop();
    this.router.navigate(['']);
  }
}
