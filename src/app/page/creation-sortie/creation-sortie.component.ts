import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { SortieService } from '@app/service/sortie.service';
import { ToastService } from '@app/service/toast.service';
import { ToastType } from 'src/model/toast.model';
import { CreateSortie } from 'src/model/createSortie.model';

@Component({
  selector: 'app-creation-sortie',
  imports: [FormsModule],
  templateUrl: './creation-sortie.component.html',
})
export class CreationSortieComponent implements OnInit {
  id: number | null = null;
  sortie = {
    name: '',
    listUser: '',
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private toastService: ToastService,
    private sortieService: SortieService
  ) {}

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    this.id = idParam ? Number(idParam) : null;
  }

  onSubmit(form: any) {
    if (form.invalid) {
      this.toastService.createToast(
        'Veuillez remplir tous les champs',
        ToastType.ERROR
      );
      return;
    }

    const listUserId = this.sortie.listUser
      .split(',')
      .map((id) => parseInt(id.trim()));

    const createSortie: CreateSortie = {
      userId: this.id!,
      groupName: this.sortie.name!,
      userIds: listUserId,
    };

    this.sortieService.createSortie(createSortie).subscribe({
      next: () => {
        this.toastService.createToast('Sortie crée !', ToastType.SUCCESS);
        this.router.navigate([`home/${this.id}`]);
      },
      error: (err) => {
        this.toastService.createToast(err.error.message, ToastType.ERROR);
      },
    });
  }
}
