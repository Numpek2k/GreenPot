import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {User} from "../models/user";
import {Observable, of} from "rxjs";
import {BASE_URL} from "../utility/globals";
import {Token} from "../models/token";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  user?:User;

  register(user: User): Observable<User> {
    let url = BASE_URL + '/auth/register';
    return this.http.post<User>(url, user);
  }

  login(email: string, password: string): Observable<Token> {
    let url = BASE_URL + '/auth/login';

    const body = new HttpParams()
      .set('email', email)
      .set('password', password);

    return this.http.post<Token>(url, body.toString(), {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/x-www-form-urlencoded')
    });
  }

  getCurrentUser(): Observable<User> {
    if(this.user){
      return of<User>(this.user).pipe()
    }

    let url = BASE_URL + '/user/getcurrent';
    let response = this.http.get<User>(url);
    response.subscribe(user => this.setUser(user))
    return response;
  }

  getUser(): Observable<User>{
    if (this.user) {
      return of<User>(this.user).pipe()
    }
    return this.getCurrentUser();
  }

  getUserById(id: number): Observable<User> {
    let url = BASE_URL + '/user/by-id';
    return this.http.get<User>(url,{
      params: new HttpParams().set('id',id)
    });
  }

  setUser(user: User): void{
    this.user = user;
  }

  isUserFollowingPlant(id: number): Observable<boolean>{
    let url = BASE_URL + '/user/is-following-plant';
    return this.http.get<boolean>(url,{
      params: new HttpParams().set('id',id)
    });
  }

  followPlant(id: number): Observable<boolean>{
    let url = BASE_URL + '/user/follow-plant';
    return this.http.post<boolean>(url,{},{
      params: new HttpParams().set('id',id)});
  }

  unFollowPlant(id: number): Observable<boolean>{
    let url = BASE_URL + '/user/un-follow-plant';
    return this.http.delete<boolean>(url,{
      params: new HttpParams().set('id',id)
    });
  }

}
