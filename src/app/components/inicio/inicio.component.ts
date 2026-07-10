import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css' // o .scss si lo usas así
})
export class InicioComponent implements OnInit, OnDestroy {

  // Aquí manejamos las rutas de tus imágenes para el fondo
  imagenesCampo: string[] = [
    'img/manos.png',
    'img/campesinos_productos.png', // Imagen de ejemplo 2
    'img/Cosecha.jpeg'  // Imagen de ejemplo 3
  ];

  indiceActivo: number = 0;
  timerCarrusel: any;

  ngOnInit(): void {
    // Cambia la imagen de fondo de manera automática cada 5 segundos
    this.timerCarrusel = setInterval(() => {
      this.siguienteImagen();
    }, 5000);
  }

  siguienteImagen(): void {
    this.indiceActivo = (this.indiceActivo + 1) % this.imagenesCampo.length;
  }

  // Si el usuario presiona los círculos de abajo, cambia de inmediato
  seleccionarImagen(index: number): void {
    this.indiceActivo = index;
  }

  ngOnDestroy(): void {
    // Destruimos el temporizador al salir de la vista para cuidar el rendimiento
    if (this.timerCarrusel) {
      clearInterval(this.timerCarrusel);
    }
  }
}
