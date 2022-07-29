import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../Service/authentication.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  title = 'Return Order Management'
  isloggedin: any;
  constructor(private authService: AuthenticationService, private route: Router) { }

  ngOnInit(): void {
    this.isloggedin = this.authService.isLoggedIn();

  }

  logout() {
    this.authService.logout();
  }

}
