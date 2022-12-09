import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {TokenService} from "../../services/token.service";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private router: Router,
              private tokenService: TokenService,
              private userService: UserService,
  ) { }
  user?: number

  ngOnInit(): void {
    this.userService.getUser().subscribe({
      next: value => this.user = value.id
    })
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
