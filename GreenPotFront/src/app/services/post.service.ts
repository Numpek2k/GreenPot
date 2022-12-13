import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpParams, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {BASE_URL} from "../utility/globals";
import {Plant} from "../models/plant";
import {Comment} from "../models/comment";
import {Post} from "../models/post";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  baseUrl = BASE_URL + '/post'

  getAllPosts(): Observable<Post[]>{
    let url = this.baseUrl + '/all'
    return this.http.get<Post[]>(url);
  }

  getPostById(id: number): Observable<Post>{
    let url = this.baseUrl + '/by-id'
    let httpParams = new HttpParams().set('id', id)
    return this.http.get<Post>(url, {params: httpParams});
  }

  getLatestPostWithLimit():Observable<Post[]>{
    let url = this.baseUrl + '/latest-limit'
    return this.http.get<Post[]>(url);
  }

  getCommentByPostId(id: number): Observable<Comment[]>{
    let url = this.baseUrl + '/comment-by-post'
    let httpParams = new HttpParams().set('id', id)
    return this.http.get<Comment[]>(url, {params: httpParams});
  }

  getPostByAuthor(id: number): Observable<Post[]> {
    let url = this.baseUrl + '/by-author';
    return this.http.get<Post[]>(url,{
      params: new HttpParams().set('id',id)
    });
  }

  addCommentToPost(comment: Comment, postId: number){
    let url = this.baseUrl + '/add-comment'
    let httpParams = new HttpParams().set('id', postId)
    return this.http.post(url,comment, {params: httpParams});
  }

  savePost(post: Post): Observable<number> {
    let url = this.baseUrl + '/save'
    return this.http.post<number>(url,post)
  }

  upload(file: File, id: number): Observable<HttpEvent<any>>  {
    const formData: FormData = new FormData();
    let url = this.baseUrl + '/upload';

    formData.append('file', file);
    let httpParams = new HttpParams().set('id',id);

    const req = new HttpRequest('POST', url, formData, {
      reportProgress: true,
      responseType: 'json',
      params: httpParams
    });
    return this.http.request(req);
  }
}
