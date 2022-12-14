import { Injectable } from '@angular/core';
import {  ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../Service/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authservice : AuthenticationService,
              private route : Router ){
  }
  // function for checking for login session
  canActivate(){
    if(this.authservice.isLoggedIn()){
     return true;
    }
    else{
      this.route.navigate(['/login']);
      return false;
    }
  }
}
