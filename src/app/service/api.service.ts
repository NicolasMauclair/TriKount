import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private apiUrl = 'http://localhost:8081/api';

  constructor(private http: HttpClient) { }

  // Méthode générique GET
  get<T>(endpoint: string, params?: any): Observable<T> {
    return this.http.get<T>(`${this.apiUrl}/${endpoint}`, { params }).pipe(
      catchError(this.handleError)
    );
  }

  // Méthode générique POST
  post<T>(endpoint: string, body: any): Observable<T> {
    return this.http.post<T>(`${this.apiUrl}/${endpoint}`, body).pipe(
      catchError(this.handleError)
    );
  }

  // Méthode générique PUT
  put<T>(endpoint: string, body: any): Observable<T> {
    return this.http.put<T>(`${this.apiUrl}/${endpoint}`, body).pipe(
      catchError(this.handleError)
    );
  }

  // Méthode générique DELETE
  delete<T>(endpoint: string): Observable<T> {
    return this.http.delete<T>(`${this.apiUrl}/${endpoint}`).pipe(
      catchError(this.handleError)
    );
  }

  // Gestion des erreurs
  private handleError(error: HttpErrorResponse): Observable<never> {
    // Logique d'erreur plus détaillée
    console.error('Erreur HTTP:', error.message);
    // Tu peux personnaliser la gestion des erreurs ici (affichage d'un message d'erreur, etc.)
    return throwError('Une erreur est survenue. Veuillez réessayer plus tard.');
  }
}
