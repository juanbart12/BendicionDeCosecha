import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
// !!! ESTA ES LA IMPORTACIÓN QUE TE FALTA !!!
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  // AGREGA 'RouterModule' AQUÍ
  imports: [CommonModule, RouterModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent { }
