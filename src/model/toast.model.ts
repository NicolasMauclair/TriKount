export enum ToastType {
  SUCCESS, ERROR
}

export class Toast {
  id: number;
  message: string;
  type: ToastType;
  duration: number;

  constructor(message: string, type: ToastType) {
    this.id = Date.now();
    this.message = message;
    this.type = type;
    this.duration = 5000;
  }
}