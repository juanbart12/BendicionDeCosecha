import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar.component';
// 1. Importa el componente aquí
import { ProductGridComponent } from './components/product-grid/product-grid.component';
// 2. Si ya hiciste el footer, impórtalo también
import { FooterComponent } from './components/footer/footer.component';

@Component({
  selector: 'app-root',
  standalone: true,
  // 3. Agrégalos todos aquí abajo
  imports: [
    RouterOutlet,
    NavbarComponent,
    ProductGridComponent,
    FooterComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'BendicionDeCosecha';
}
