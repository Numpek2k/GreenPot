import { Component, OnInit } from '@angular/core';
import {UntypedFormBuilder, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {samePasswordValidator} from "../../utility/passwordValidation";
import {User} from "../../utility/user";
import {UserService} from "../../services/user.service";
import {TokenService} from "../../services/token.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private formBuilder: UntypedFormBuilder,
              private router: Router,
              private userService: UserService,
              private tokenService: TokenService) { }

  registerForm = this.formBuilder.group({
    name: ['', [Validators.required]],
    surname: ['', [Validators.required]],
    password: ['', {validators: [Validators.required, Validators.minLength(8),Validators.pattern("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$")], updateOn: 'blur'}],
    password2: ['', {validators: Validators.required, updateOn: 'blur'}],
    email: ['', {validators: [Validators.email, Validators.required], updateOn: 'blur'}],
  }, {validators: samePasswordValidator});

  errorMessage = "";

  ngOnInit(): void {
  }

  onSubmitRegister(): void{
    let user: User ={
      name: this.name.value,
      surname:this.surname.value,
      email:this.email.value,
      password:this.password.value,
    }
    this.userService.register(user)
      .subscribe({
        next: user => this.successfulRegister(user),
        error: err => this.errorMessage = err.error.text
      });
  }

  successfulRegister(user: User) {
    this.userService.user = user;
    this.userService.login(user.email, this.password.value).subscribe(tokens => this.tokenService.setTokens(tokens))
    this.router.navigate(['/']);
  }

  get name(){
    return this.registerForm.controls['name']
  }

  get surname(){
    return this.registerForm.controls['surname']
  }

  get email(){
    return this.registerForm.controls['email']
  }

  get password(){
    return this.registerForm.controls['password']
  }

  get password2(){
    return this.registerForm.controls['password2']
  }

}
