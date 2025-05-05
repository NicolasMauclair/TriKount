import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserService } from '@app/service/user.service';
import { Router } from '@angular/router';
import { ToastService } from '@app/service/toast.service';
import { ToastType } from 'src/model/toast.model';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.component.html',
})
export class LoginComponent {
  user = {
    username: '',
    password: '',
  };

  constructor(private userService: UserService, private toastService: ToastService, private router: Router) {}

  onSubmit(form: any) {
    if (form.invalid) {
      this.toastService.createToast('Veuillez remplir tous les champs', ToastType.ERROR);
      return;
    }

    this.userService.login(this.user.username, this.user.password).subscribe({
      next: (user) => {
        const userId = user.id;
        this.toastService.createToast('Connexion réussie', ToastType.SUCCESS);
        this.router.navigate(['home'], { queryParams: { id: userId } });
      },
      error: (err) => {
        console.error('Erreur lors de la connexion:', err);
        this.toastService.createToast('Identifiants incorrects', ToastType.ERROR);
      },
    });
  }

  register() {
    this.router.navigate(['register']);
  }
}
