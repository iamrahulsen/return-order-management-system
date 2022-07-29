import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { AuthenticationService } from '../../Service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm?: FormGroup;
  loading = false;
  submitted = false;
  returnUrl?: string;
  authService: AuthenticationService;
  errorMessage?: string
  route;
  constructor(authService: AuthenticationService, route: Router) {
    this.authService = authService;
    this.route = route;
  }

  ngOnInit() {
    if (this.authService.isLoggedIn())
      if ((!!sessionStorage.getItem('expiration_time')) && !!sessionStorage.getItem('jwt_token')) {
        if (JSON.parse(sessionStorage.getItem('expiration_time') || '') > (Date.now() + ''))
          this.route.navigate(['/orderform']);
      }

  }

  log(x: any) {
    console.log("Username changed")
    console.log(x);
  }

  onSubmit(form: NgForm) {
    this.submitted = true;
    console.log(form.value)
    this.authService.authUser(form.value).subscribe(
      responseData => {
        console.log(responseData)
        console.log(responseData.jwt)
        sessionStorage.setItem('jwt_token', responseData.jwt);
        sessionStorage.setItem('expiration_time', (Date.now() + 1000 * 60 * 30) + '');
        this.route.navigate(['/orderform']);
      }, error => {
        console.log(error)
        switch (error.status) {

          case 401:
            this.errorMessage = "Invalid Username/Password";
            break;
          case 403:
            this.errorMessage = "Invalid Username/Password";
            break;
          default:
            this.errorMessage = "Something went wrong";
        }
      })

    this.submitted = false;
  }


}
