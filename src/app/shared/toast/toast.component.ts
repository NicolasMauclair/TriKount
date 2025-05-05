import { Component, Input  } from '@angular/core';
import { Toast, ToastType } from 'src/model/toast.model';
import { ToastService } from '@app/service/toast.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-toast',
  imports: [CommonModule],
  templateUrl: './toast.component.html'
})
export class ToastComponent {

  constructor(public toastService: ToastService) { }

  isSuccess(toast: Toast) {
    return toast.type == ToastType.SUCCESS
  }

  isError(toast: Toast) {
    return toast.type == ToastType.ERROR
  }

  removeToast(toast: Toast) {
    this.toastService.removeToast(toast);
  }

}
