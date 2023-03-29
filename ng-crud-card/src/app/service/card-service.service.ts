import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { map, Observable } from 'rxjs';
import { CardModel } from '../model/card-model';

@Injectable({
  providedIn: 'root'
})
export class CardServiceService {

  constructor(private http:HttpClient) { }
  
  getCar(): Observable<CardModel[]>{
    return this.http.get<CardModel[]>('http://localhost:9000/api'+'/list').pipe(map(res => res));
  }
  saveCard(req:any): Observable<any>{
    return this.http.post<any>('http://localhost:9000/api'+'/save' , req).pipe(map(res => res));
  }
  updateCard(req:any): Observable<any>{
    return this.http.put<any>('http://localhost:9000/api'+'/update' , req).pipe(map(res => res));
  }
  deleteCard(id:number): Observable<any>{
    return this.http.put<any>('http://localhost:9000/api'+'/delete' , id).pipe(map(res => res));
  }
  
}
