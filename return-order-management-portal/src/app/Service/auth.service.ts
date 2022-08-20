import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { __await } from 'tslib';
import { authToken } from '../Models/auth-token';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private http;
  static jwt: any;
  errorMessage?: string;

  constructor(http: HttpClient, private route: Router) {
    this.http = http;
  }


  authUser(loginbody: any) {
    return this.http.post<authToken>('http://54.250.187.28:9001/authenticate', loginbody)

  }

  isLoggedIn() {
    if ((!!sessionStorage.getItem('expiration_time')) && !!sessionStorage.getItem('jwt_token')) {
      if (JSON.parse(sessionStorage.getItem('expiration_time') || '') > (Date.now() + ''))
        return JSON.parse(sessionStorage.getItem('expiration_time') || '') > (Date.now() + '');
    }
    return false;
  }

  getToken() {
    return sessionStorage.getItem('jwt_token')
  }

  logout() {
    sessionStorage.removeItem('expiration_time');
    sessionStorage.removeItem('jwt_token');
    this.route.navigate(['login']);
  }

}
