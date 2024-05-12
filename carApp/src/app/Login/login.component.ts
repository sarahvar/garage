import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string | undefined;
  password: string | undefined;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient) {}

  onSubmit() {
    const headers = new HttpHeaders({
      'Authorization': 'Basic ' + btoa(this.username + ':' + this.password),
      'Content-Type': 'application/json'
    });

    this.http.post('http://localhost:4200/login', {}, { headers: headers })
      .subscribe(response => {
        console.log(response);
      }, error => {
        console.log(error);
      });

      this.router.navigate(['/cars']);


  }
}
