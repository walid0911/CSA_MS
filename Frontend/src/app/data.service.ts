import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  constructor(private http: HttpClient) { }

  getData() {
    return this.http.get('http://localhost:8080/users');
  }

  postNewUser(data: any) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.http.post('http://localhost:8080/users/add', data, { headers }).subscribe(
      response => console.log(response),
      error => console.error(error)
    );
    return this.http.get('http://localhost:8080/users');
  }

  deleteUser(id: String) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.http.delete('http://localhost:8080/users/delete/' + id, { headers }).subscribe(
      response => console.log(response),
      error => console.error(error)
    );
    return this.http.get('http://localhost:8080/users');
  }
}
