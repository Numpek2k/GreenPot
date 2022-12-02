import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {PlantAllDataDto} from "../dto/plantAllDataDto";
import {Observable} from "rxjs";
import {BASE_URL} from "../utility/globals";

@Injectable({
  providedIn: 'root'
})
export class PlantService {

  constructor( private http: HttpClient) { }

  getAllDataPlantById(id: number): Observable<PlantAllDataDto> {
    let url = BASE_URL + '/plant/all-info/id';
    return this.http.get<PlantAllDataDto>(url,{
      params: new HttpParams().set('id',id)
    });
  }
}
