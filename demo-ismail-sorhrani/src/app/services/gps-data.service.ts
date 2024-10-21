import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class GpsDataService {
  private apiUrl = 'http://localhost:8082/api/gps/coordinates'; // Remplacez par l'URL de votre API

  constructor(private http: HttpClient) { }

  getGpsCoordinates(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }

}
