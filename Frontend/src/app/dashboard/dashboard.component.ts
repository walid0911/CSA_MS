import { Component, OnInit } from '@angular/core';
import { DataService } from "../data.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{
  data: any;
  nom: String | undefined;
  prenom: String | undefined;
  dateNaissance: String | undefined;

  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.dataService.getData().subscribe((response) => {
      this.data = response;
    });
  }

  onSubmit() {
    const formData = {
      firstName : this.prenom,
      lastName : this.nom,
      birthDate : this.dateNaissance
    }
    this.dataService.postNewUser(formData).subscribe((response) => {
      this.data = response;
    });
  }

  deleteUser(id: String) {
    this.dataService.deleteUser(id).subscribe((response) => {
      this.data = response;
    });
  }
}
