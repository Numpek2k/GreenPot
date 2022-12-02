import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Token} from "../models/token";
import {Router} from "@angular/router";
import jwt_decode from "jwt-decode";
import {BASE_URL} from "../utility/globals";
import {catchError, of, tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor(private http: HttpClient,
              private router: Router) { }

  getToken(): string | null{
    let token = localStorage.getItem('access_token');
    if (!token) return null;
    let valid = this.isTokenValid(token);
    if (!valid) {
      this.refresh();
      token = localStorage.getItem('access_token');
    }
    return token;
  }

  setTokens(tokens : Token): void{
    localStorage.setItem('access_token', tokens.access_token);
    localStorage.setItem('refresh_token', tokens.refresh_token);
  }

  refreshToken() {
    let url = BASE_URL + '/auth/reftoken';
    return this.http
      .post<any>(url, {
        refreshToken: localStorage.getItem('refresh_token'),
      })
      .pipe(
        tap((tokens) => {
          this.setTokens(tokens);
        }),
        catchError((error) => {
          this.logout();
          return of(false);
        })
      );
  }


  refresh() {
    let url = BASE_URL + '/auth/reftoken';

    let token = localStorage.getItem('refresh_token');
    if (!token){
      this.logout();
      return;
    }

    let valid = this.isTokenValid(token);
    if (!valid) {
      this.logout()
      return;
    }

    this.http.get<Token>(url, {
      headers: new HttpHeaders()
        .set('Authorization', token)
    }).subscribe({
      next: tokens => this.setTokens(tokens),
      error: err => {
        if(err.status === 401)
          this.logout()
      }
    });
  }

  getAuthorizationHeader(): HttpHeaders{
    let token = this.getToken();
    if(!token) {
      this.router.navigate(['/login']);
      throw Error('login first');
    }
    return new HttpHeaders().set('Authorization', token)
  }

  isLoggedIn(): boolean{
    return this.getToken() !== null;
  }

  logout(): void{
    localStorage.clear();
    this.router.navigate(["/"]);
  }

  isTokenValid(token: string): boolean{
    token = token.substring("Bearer ".length)
    let tokenExp: any;
    ({exp: tokenExp} = jwt_decode(token));
    let dateNow = Date.now()
    return tokenExp * 1000 - dateNow >= 1000;
  }
}
