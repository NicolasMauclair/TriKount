import { Injectable } from '@angular/core';
import { Toast, ToastType } from 'src/model/toast.model';

@Injectable({
  providedIn: 'root'
})
export class ToastService {

  toasts: Toast[] = [];

  constructor() { }

  createToast(message: string, type: ToastType) {

    const toast = (new Toast(message, type));

    this.toasts.push(toast);

    setTimeout(() => {
      this.removeToast(toast);
    }, toast.duration);
  }

  removeToast(toast: Toast) {
    this.toasts = this.toasts.filter(t => t.id !== toast.id);
  }

}
