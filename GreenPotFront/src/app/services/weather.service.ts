import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  constructor(private http: HttpClient) { }

  baseUrl = 'https://api.openweathermap.org/data/3.0/onecall'

  getWeatherForecast(lat: string, lon: string): Observable<any>{
    let httpParams = new HttpParams()
      .set('lat',lat)
      .set('lon',lon)
      .set('exclude', 'currently,minutely,hourly,alerts')
      .set('units', 'metric')
      .set('lang', 'en')
      .set('appid', '2776b2c963f1bbfcdfed501a21c3b2f8')

    // let httpHeaders = new HttpHeaders()
    //   .set('X-RapidAPI-Key', '0ecdf88421msh61d5d7be6219ed7p11a6f4jsn2bbc9b9dac77')
    //   .set('X-RapidAPI-Host', 'dark-sky.p.rapidapi.com')


    return this.http.get<any>(this.baseUrl,{
      // headers: httpHeaders,
      params: httpParams
    })
  }
}
