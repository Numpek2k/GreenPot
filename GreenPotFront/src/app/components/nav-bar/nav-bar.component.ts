import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {TokenService} from "../../services/token.service";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private router: Router,
              private tokenService: TokenService,
  ) { }

  ngOnInit(): void {
  }

  isVisible(): boolean {
    return !(this.router.url === '/login' || this.router.url === '/register')
  }

  logout(): void {
    this.tokenService.logout();
  }

  isLoggedIn(): boolean{
    return this.tokenService.isLoggedIn();
}

}
