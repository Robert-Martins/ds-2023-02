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
import { AvatarComponent } from './avatar/avatar.component';
import { SplashScreenComponent } from './splash-screen/splash-screen.component';
import { DirectivesModule } from '../directives/directives.module';
import { PipesModule } from '../pipes/pipes.module';


@NgModule({
  declarations: [
    AvatarComponent,
    SnackbarComponent, 
    SplashScreenComponent
  ],
  imports: [
    CommonModule,
    CardsModule,
    ContainersModule,
    DirectivesModule,
    PipesModule,
    DialogsModule,
    HeaderModule,
    InputsModule,
    ListsModule,
    SidebarModule,
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
    SplashScreenComponent,
  ],
})
export class ComponentsModule {}
