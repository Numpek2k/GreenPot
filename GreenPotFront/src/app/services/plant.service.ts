import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {PlantAllDataDto} from "../dto/plantAllDataDto";
import {Observable} from "rxjs";
import {BASE_URL} from "../utility/globals";
import {Plant} from "../models/plant";
import {MyCalendarDTO} from "../dto/MyCalendarDTO";
import {Image} from "../models/image";

@Injectable({
  providedIn: 'root'
})
export class PlantService {

  constructor( private http: HttpClient) { }

  baseUrl = BASE_URL + '/plant'

  getAllDataPlantById(id: number): Observable<PlantAllDataDto> {
    let url = this.baseUrl + '/info/id';
    return this.http.get<PlantAllDataDto>(url,{
      params: new HttpParams().set('id',id)
    });
  }

  getPlantByAuthor(id: number): Observable<Plant[]>{
    let url = this.baseUrl + '/by-author';
    return this.http.get<Plant[]>(url,{
      params: new HttpParams().set('id',id)
    });
  }

  getAllPlants(): Observable<PlantAllDataDto[]>{
    let url = this.baseUrl + '/all'
    return this.http.get<PlantAllDataDto[]>(url)
  }

  getMyCalender(): Observable<MyCalendarDTO[]>{
    let url = this.baseUrl + '/my-calendar'
    return this.http.get<MyCalendarDTO[]>(url)
  }

  getPlantByMainCategory(category: string):Observable<PlantAllDataDto[]>{
    let url = this.baseUrl + '/category'
    let httpParams = new HttpParams().set('category',category)
    return this.http.get<PlantAllDataDto[]>(url,{params: httpParams})
  }

  getPlantBySubCategory(categories: string){
    let url = this.baseUrl + '/sub-cat'
    let httpParams = new HttpParams().set('category',categories)
    return this.http.get<PlantAllDataDto[]>(url,{params: httpParams})
  }

  getImageByPlantIdLimit1(id: number): Observable<Image>{
    let url = this.baseUrl + '/image-by-plant-id'
    let httpParams = new HttpParams().set('id',id)
    return this.http.get<Image>(url,{params: httpParams})
  }
}
