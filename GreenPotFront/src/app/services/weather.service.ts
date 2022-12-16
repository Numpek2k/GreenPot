import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  constructor(private http: HttpClient) { }

  baseUrl = 'https://dark-sky.p.rapidapi.com/'

  getWeatherForecast(lat: string, lon: string): Observable<any>{
    let url = this.baseUrl + lat + ',' + lon
    let httpParams = new HttpParams()
      .set('exclude', 'currently,minutely,hourly,alerts,flags')
      .set('units', 'auto')
      .set('lang', 'en')

    let httpHeaders = new HttpHeaders()
      .set('X-RapidAPI-Key', 'c9322d7c25msh02cfcc88443de3fp184c9ajsn0b7121619e21')
      .set('X-RapidAPI-Host', 'dark-sky.p.rapidapi.com')


    return this.http.get<any>(url,{
      headers: httpHeaders,
      params: httpParams
    })
  }
}
