import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpParams, HttpRequest} from "@angular/common/http";
import {PlantAllDataDto} from "../dto/plantAllDataDto";
import {Observable} from "rxjs";
import {BASE_URL} from "../utility/globals";
import {Plant} from "../models/plant";
import {MyCalendarDTO} from "../dto/MyCalendarDTO";
import {Image} from "../models/image";
import {Events} from "../models/events";
import {Post} from "../models/post";

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

  getLatestPlantWithLimit():Observable<Plant[]>{
    let url = this.baseUrl + '/latest-limit'
    return this.http.get<Plant[]>(url);
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

  getAllEvents(): Observable<Events[]>{
    let url = this.baseUrl + '/event/all'
    return this.http.get<Events[]>(url)
  }

  upload(file: File,id: number): Observable<HttpEvent<any>> {
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

  savePlant(plant: Plant): Observable<number> {
    let url = this.baseUrl + '/save'
    return this.http.post<number>(url,plant)
  }
}
