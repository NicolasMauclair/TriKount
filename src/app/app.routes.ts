import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'login',
    loadComponent: () =>
      import('./auth/login/login.component').then(m => m.LoginComponent),
  },
  {
    path: 'register',
    loadComponent: () =>
      import('./auth/register/register.component').then(m => m.RegisterComponent),
  },
  {
    path: 'home',
    loadComponent: () =>
      import('./page/home/home.component').then(m => m.HomeComponent),
  },
  {
    path: 'sortie/:id',
    loadComponent: () =>
      import('./page/sortie/sortie.component').then(m => m.SortieComponent),
  },
  {
    path: 'creation-sortie/:id',
    loadComponent: () =>
      import('./page/creation-sortie/creation-sortie.component').then(m => m.CreationSortieComponent),
  },
];
