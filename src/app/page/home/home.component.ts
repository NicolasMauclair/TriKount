import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '@app/service/user.service';
import { UserSummary } from 'src/model/user-summary.model';
import { Sortie } from 'src/model/sortie.model';

@Component({
  selector: 'app-home',
  imports: [CommonModule],
  templateUrl: './home.component.html',
})
export class HomeComponent implements OnInit {
  id: any = null;
  user: UserSummary | undefined;
  ListSortieCreate: Sortie[] = [];
  ListSortieJoin: Sortie[] = [];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserService
  ) {}

  ngOnInit() {
    this.route.queryParamMap.subscribe((params) => {
      this.id = params.get('id');
      this.userService.getUserById(this.id).subscribe((user) => {
        this.user = user;
        this.getSortie(this.id);
        console.log(this.user);
      });
    });
  }

  getSortie(idUser: string) {
    this.userService.getSortiesCreated(idUser).subscribe((sorties: Sortie[]) => {
      this.ListSortieCreate = sorties;
      console.log(this.ListSortieCreate);
    });
    this.userService.getSortiesJoined(idUser).subscribe((sorties: Sortie[]) => {
      this.ListSortieJoin = sorties;
    });
  }

  goToSortie(id: number) {
    this.router.navigate([`sortie/${id}`]);
  }

  createSortie() {
    this.router.navigate([`creation-sortie/${this.id}`]);
  }
  
}
