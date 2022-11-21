import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {User} from "../utility/user";
import {Observable} from "rxjs";
import {BASE_URL} from "../utility/globals";
import {TokenService} from "./token.service";
import {Token} from "../utility/token";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient,
              private tokenService: TokenService) { }

  user?:User;

  register(user: User): Observable<User> {
    let url = BASE_URL + '/user/save';
    return this.http.post<User>(url, user);
  }

  login(email: string, password: string): Observable<Token> {
    let url = BASE_URL + '/login';

    const body = new HttpParams()
      .set('email', email)
      .set('password', password);

    return this.http.post<Token>(url, body.toString(), {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/x-www-form-urlencoded')
    });
  }

  getCurrentUser(): Observable<User> {
    let url = BASE_URL + '/user/getcurrent';
    let response = this.http.get<User>(url, {
      headers: this.tokenService.getAuthorizationHeader()
    });
    response.subscribe(user => this.setUser(user))
    return response;
  }

  setUser(user: User): void{
    this.user = user;
  }

}
