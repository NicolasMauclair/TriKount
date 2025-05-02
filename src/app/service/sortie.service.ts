import { Injectable } from '@angular/core';
import { ApiService } from '@app/service/api.service';
import { Observable } from 'rxjs';
import { Sortie } from 'src/model/sortie.model';

@Injectable({
  providedIn: 'root'
})
export class SortieService {

  constructor(private apiService: ApiService) { }

  getSortie(idUser: number): Observable<Sortie> {
    return this.apiService.get('sortie/getSortie/' + idUser);
  }
}
