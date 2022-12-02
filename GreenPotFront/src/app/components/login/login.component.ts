import { Component, OnInit } from '@angular/core';
import {UntypedFormBuilder, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {Token} from "../../models/token";
import {TokenService} from "../../services/token.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private formBuilder: UntypedFormBuilder,
              public userService: UserService,
              private router: Router,
              private tokenService: TokenService) { }

  incorrectCredentials = false;

  loginForm = this.formBuilder.group({
      email: ['', {validators: [Validators.required, Validators.email], updateOn: 'blur'}],
      password: ['', Validators.required]
    }
  )

  ngOnInit(): void {
  }

  get email(){
    return this.loginForm.controls['email']
  }

  onLogin(): void {
    let cred = this.loginForm.value;
    this.userService.login(cred.email,cred.password).subscribe({
      next: tokens => {
        this.successfulLogin(tokens);
      },
      error: err => {
        if(err.status == 401){
          this.incorrectCredentials = true;
        }
      }
    })
  }

  successfulLogin(tokens: Token) {
    this.tokenService.setTokens(tokens);
    this.userService.getCurrentUser();
    this.router.navigate(['/']);
  }
}

