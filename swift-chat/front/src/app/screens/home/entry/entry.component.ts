import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-entry',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterOutlet],
  templateUrl: './entry.component.html',
  styleUrl: './entry.component.css',
})
export class EntryComponent implements OnInit {
  name: string;

  constructor() {}

  ngOnInit() {}

  entryCode() {}

  entryQRCode() {}
}
