import { Routes } from '@angular/router';
// IMPORTANTE: Aquí es donde quitas el color rojo
import { InicioComponent } from './components/inicio/inicio.component';
import { ProductosComponent } from './components/productos/productos.component';
import { NosotrosComponent } from './components/nosotros/nosotros.component';
import { BeneficiosComponent } from './components/beneficios/beneficios.component';
import { ContactoComponent } from './components/contacto/contacto.component';

export const routes: Routes = [
  { path: '', component: InicioComponent },
  { path: 'productos', component: ProductosComponent },
  { path: 'nosotros', component: NosotrosComponent },
  { path: 'beneficios', component: BeneficiosComponent },
  { path: 'contacto', component: ContactoComponent },
  { path: '**', redirectTo: '' } // Esto redirige cualquier error al inicio
];
