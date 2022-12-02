import { Injectable } from '@angular/core';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";
import {TokenService} from "../services/token.service";

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor{

  constructor(private tokenService: TokenService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = localStorage.getItem('access_token')
    const refToken = localStorage.getItem('refresh_token')
    let cloneReq = req
    if(token && this.tokenService.isTokenValid(token)){
      cloneReq = req.clone({
        setHeaders:{
          Authorization: token,
        }
      });
    }
    else if(refToken && this.tokenService.isTokenValid(refToken)){
      cloneReq = req.clone({
        setHeaders:{
          Authorization: refToken,
        }
      });
    }
    return next.handle(cloneReq).pipe(
      catchError((err : HttpErrorResponse) => {

        return throwError(() => err);
      })
    )
  }
}
