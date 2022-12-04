import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Category} from "../models/category";
import {BASE_URL} from "../utility/globals";
import {HttpClient} from "@angular/common/http";
import {SubCategory} from "../models/subCategory";

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {

  constructor(private http: HttpClient) { }

  baseUrl = BASE_URL + '/plant'

  getAllMainCategories(): Observable<Category[]>{
    let url = this.baseUrl + '/main-category/all'
    return this.http.get<Category[]>(url);
  }

  getAllSubCategories(): Observable<SubCategory[]>{
    let url = this.baseUrl + '/sub-category/all'
    return this.http.get<SubCategory[]>(url)
  }
}
