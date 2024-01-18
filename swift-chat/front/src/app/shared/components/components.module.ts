import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { CardsModule } from './cards/cards.module';
import { ContainersModule } from './containers/containers.module';
import { DialogsModule } from './dialogs/dialogs.module';
import { HeaderModule } from './header/header.module';
import { InputsModule } from './inputs/inputs.module';
import { ListsModule } from './lists/lists.module';
import { SidebarModule } from './sidebar/sidebar.module';
import { SnackbarComponent } from './snackbar/snackbar.component';
import { SplashScreenComponent } from './splash-screen/splash-screen.component';

@NgModule({
  declarations: [SnackbarComponent, SplashScreenComponent],
  imports: [
    CommonModule,
    CardsModule,
    ContainersModule,
    DialogsModule,
    HeaderModule,
    InputsModule,
    ListsModule,
    SidebarModule,
  ],
  exports: [
    CardsModule,
    ContainersModule,
    DialogsModule,
    HeaderModule,
    InputsModule,
    ListsModule,
    SidebarModule,
    SnackbarComponent,
    SplashScreenComponent,
  ],
})
export class ComponentsModule {}
