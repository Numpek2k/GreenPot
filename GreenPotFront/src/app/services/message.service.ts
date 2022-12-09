import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Message} from "../models/message";
import {BASE_URL} from "../utility/globals";
import {Observable} from "rxjs";
import {User} from "../models/user";

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http: HttpClient) { }

  baseUrl = BASE_URL + '/message'

  send(message: Message, receiver: number): void{
    let url = this.baseUrl + '/save';
    let params = new HttpParams().set('receiver',receiver)

    this.http.post(url, message, {
      params: params
    }).subscribe({
      error: err => {
        console.log(err)
      }
    });
  }

  getAllReceivers(): Observable<User[]>{
    let url = this.baseUrl + '/receivers-all'
    return this.http.get<User[]>(url);
  }

  getAllMessages(receiver: number): Observable<Message[]>{
    let url = this.baseUrl + '/user-to-user-all'
    let param = new HttpParams().set('receiverId', receiver);
    return this.http.get<Message[]>(url,{
      params: param
    })
  }
}
