import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserService } from '@app/service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [FormsModule],
  templateUrl: './register.component.html',
})
export class RegisterComponent {
  user = {
    username: '',
    password: '',
  };

  constructor(private userService: UserService, private router: Router) {}

  onSubmit(form: any) {
    if (form.invalid) {
      return;
    }

    this.userService.register(this.user.username).subscribe({
      next: (user) => {
        const userId = user.id;
        this.router.navigate(['home'], { queryParams: { id: userId } });
      },
      error: (err) => {
        console.error('Erreur lors de la connexion:', err);
      },
    });
  }

  login() {
    this.router.navigate(['login']);
  }
}
