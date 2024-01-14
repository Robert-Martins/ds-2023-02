import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet, Routes } from '@angular/router';
import { ChatComponent } from './screens/chat/chat.component';
import { CodeComponent } from './screens/code/code.component';
import { HomeComponent } from './screens/home/home.component';
import { LobbyComponent } from './screens/lobby/lobby.component';
import { ComponentsModule } from './shared/components/components.module';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, ComponentsModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Swift Chat';
}
