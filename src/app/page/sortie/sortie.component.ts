import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { SortieService } from '@app/service/sortie.service';
import { Sortie } from 'src/model/sortie.model';

@Component({
  selector: 'app-sortie',
  imports: [CommonModule],
  templateUrl: './sortie.component.html',
})
export class SortieComponent implements OnInit {
  id: number | null = null;
  sortie: Sortie = {
    id: 0,
    name: '',
    CreatedById: 0,
    users: [],
    depenses: []
  };
  ;
  isLoading: boolean = true;

  constructor( 
    private route: ActivatedRoute,
    private sortieService: SortieService
  ) {}

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    const id = idParam ? Number(idParam) : null;
  
    if (id !== null) {
      this.id = id;
      this.sortieService.getSortie(this.id).subscribe({
        next: (sortie) => {
          this.sortie = sortie;
          this.isLoading = false; // Une fois les données chargées, on met isLoading à false
          console.log(this.sortie);
        },
        error: (err) => {
          console.error('Erreur lors de la récupération de la sortie :', err);
          this.isLoading = false; // Même si erreur, on arrête l'affichage de "chargement"
        },
      });
    } else {
      console.warn('Aucun ID trouvé dans l’URL');
      this.isLoading = false; // Aucun ID -> on arrête le chargement aussi
    }
  }
}
