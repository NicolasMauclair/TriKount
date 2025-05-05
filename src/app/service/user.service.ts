import { Injectable } from '@angular/core';
import { ApiService } from '@app/service/api.service';
import { Observable } from 'rxjs';
import { Sortie } from 'src/model/sortie.model';
import { UserSummary } from 'src/model/user-summary.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private apiService: ApiService) { }

  login(username: string, password: string): Observable<UserSummary> {
    return this.apiService.post('users/login', { username, password });
  }
  
  register(username: string): Observable<UserSummary> {
    return this.apiService.post('users/createUser', { username });
  }

  getUserById(idUser: string): Observable<UserSummary> {
    return this.apiService.get('users/searchUserById/' + idUser);
  }

  getSortiesCreated(idUser: string): Observable<Sortie[]> {
    return this.apiService.get('users/getSortiesCreatedByUser/' + idUser);
  }

  getSortiesJoined(idUser: string): Observable<Sortie[]> {
    return this.apiService.get('users/getSortiesJoinedByUser/' + idUser);
  }
  
}
