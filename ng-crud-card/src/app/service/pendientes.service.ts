import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pendientes } from '../interface/pendientes';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PendientesService {

  constructor(private http:HttpClient) { }

  allPending(): any {
    return this.http.get<Pendientes[]>('http://localhost:9000/api/allPending').pipe(
      map(res => {
        return res;
      })
    );
  }
  addedPending(req:any): Observable<any>{
    return this.http.post<any>('http://localhost:9000/api/addedPending' , req).pipe(map(res => res));
  }
}
