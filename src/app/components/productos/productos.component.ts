import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // Importante para que funcionen los *ngIf y *ngFor

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './productos.component.html',
  styleUrl: './productos.component.css' // Asegúrate de que este nombre coincida con tu archivo CSS
})
export class ProductosComponent {
  // Aquí empieza la lógica que ya teníamos
  isCartOpen = false;
  isModalOpen = false;
  selectedProduct: any = null;
  cartItems: any[] = [];

  allProducts = [
    {
      id: 1,
      name: 'Papa Express',
      price: 14000,
      desc: 'Nuestra especialidad: seleccionada y lista para su uso inmediato.',
      img: 'assets/img/papa-express.jpg',
      specs: 'Papa de alta calidad, seleccionada manualmente para garantizar uniformidad. Ideal para quienes buscan rapidez sin sacrificar sabor.',
      presentations: ['Bolsa x 2kg', 'Bulto x 10kg', 'Arroba']
    },
    {
      id: 2,
      name: 'Papa a la Francesa',
      price: 16000,
      desc: 'Corte perfecto y textura crocante para tus frituras.',
      img: '/img/francesa.jpg',
      specs: 'Procesada con corte uniforme. Posee un bajo contenido de azúcares para lograr ese dorado perfecto.',
      presentations: ['Paquete x 1kg', 'Caja x 5kg']
    },
    {
      id: 3,
      name: 'Papa Criolla',
      price: 12000,
      desc: 'El sabor tradicional de nuestra tierra con calidad premium.',
      img: '/img/criolla.png',
      specs: 'Papa amarilla de Chivatá. Piel delgada y textura cremosa.',
      presentations: ['Bolsa x 1kg', 'Bulto x 10kg']
    },
    {
      id: 4,
      name: 'Papa Cabello de Ángel',
      price: 18000,
      desc: 'Corte ultra fino para preparaciones gourmet.',
      img: '/img/angel.png',
      specs: 'Corte tipo hilo de extrema precisión. Perfecta para decorar platos.',
      presentations: ['Paquete x 500g']
    },
    {
      id: 5,
      name: 'Papa Lavada',
      price: 11000,
      desc: 'Papa pastusa impecable, libre de tierra.',
      img: '/img/lavada.png',
      specs: 'Sometida a un proceso de lavado profundo. Facilita la higiene en tu cocina.',
      presentations: ['Bulto x 10kg', 'Arroba']
    }
  ];

  // --- MÉTODOS DE CONTROL ---
  toggleCart() {
    this.isCartOpen = !this.isCartOpen;
  }

  openModal(product: any) {
    this.selectedProduct = product;
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
    this.selectedProduct = null;
  }

  addToCart(product: any) {
    const existing = this.cartItems.find(i => i.id === product.id);
    if (existing) {
      existing.quantity++;
    } else {
      this.cartItems.push({ ...product, quantity: 1 });
    }
  }

  updateQuantity(item: any, change: number) {
    item.quantity += change;
    if (item.quantity <= 0) {
      this.removeFromCart(item);
    }
  }

  removeFromCart(item: any) {
    this.cartItems = this.cartItems.filter(i => i.id !== item.id);
  }

  calculateTotal() {
    return this.cartItems.reduce((acc, item) => acc + (item.price * item.quantity), 0);
  }

  checkout() {
    const message = `Hola Papa Express! Quiero realizar un pedido: ${this.cartItems.map(i => `${i.name} (x${i.quantity})`).join(', ')}. Total: $${this.calculateTotal()}`;
    window.open(`https://wa.me/573150735585?text=${encodeURIComponent(message)}`, '_blank');
  }
}
