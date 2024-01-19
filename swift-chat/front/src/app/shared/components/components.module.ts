import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardsModule } from './cards/cards.module';
import { HeaderModule } from './header/header.module';
import { InputsModule } from './inputs/inputs.module';
import { ListsModule } from './lists/lists.module';
import { SidebarModule } from './sidebar/sidebar.module';
import { ContainersModule } from './containers/containers.module';
import { SplashScreenComponent } from './splash-screen/splash-screen.component';
import { SnackbarComponent } from './snackbar/snackbar.component';
import { DialogsModule } from './dialogs/dialogs.module';
import { AvatarComponent } from './avatar/avatar.component';



@NgModule({
  declarations: [
    SnackbarComponent,
    SplashScreenComponent,
    AvatarComponent
  ],
  imports: [
    CommonModule,
    CardsModule,
    ContainersModule,
    DialogsModule,
    HeaderModule,
    InputsModule,
    ListsModule,
    SidebarModule
  ],
  exports: [
    AvatarComponent,
    CardsModule,
    ContainersModule,
    DialogsModule,
    HeaderModule,
    InputsModule,
    ListsModule,
    SidebarModule,
    SnackbarComponent,
    SplashScreenComponent
  ]
})
export class ComponentsModule { }
