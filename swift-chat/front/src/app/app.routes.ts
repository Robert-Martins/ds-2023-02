import { Routes } from '@angular/router';
import { ChatComponent } from './screens/chat/chat.component';
import { CodeComponent } from './screens/code/code.component';
import { HomeComponent } from './screens/home/home.component';
import { LobbyComponent } from './screens/lobby/lobby.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'code', component: CodeComponent },
    { path: 'lobby/:id', component: LobbyComponent },
    { path: 'chat/:id', component: ChatComponent },
    { path: '**', redirectTo: '' }
];