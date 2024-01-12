import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardsModule } from './cards/cards.module';
import { HeaderModule } from './header/header.module';
import { InputsModule } from './inputs/inputs.module';
import { ListsModule } from './lists/lists.module';
import { SidebarModule } from './sidebar/sidebar.module';
import { ContainersModule } from './containers/containers.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    CardsModule,
    ContainersModule,
    HeaderModule,
    InputsModule,
    ListsModule,
    SidebarModule
  ],
  exports: [
    CardsModule,
    ContainersModule,
    HeaderModule,
    InputsModule,
    ListsModule,
    SidebarModule
  ]
})
export class ComponentsModule { }
