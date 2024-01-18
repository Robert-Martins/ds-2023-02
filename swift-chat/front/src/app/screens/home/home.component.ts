import { CommonModule } from '@angular/common';
import { Component, Injector, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, RouterOutlet } from '@angular/router';
import { SharedModule } from '../../shared/shared.module';
import { UtilComponent } from '../../shared/components/util/util.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterOutlet, RouterModule, SharedModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent extends UtilComponent implements OnInit {
  name: string;

  constructor(
    private injector: Injector
  ) {
    super(injector);
  }

  ngOnInit() {}

  createRoom() {}

  joinRoom() {}
}
