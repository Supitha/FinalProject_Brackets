import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class HelperService {


   constructor(private _http:HttpClient) { }

  getGraphData(){
    return this._http.get("http://localhost:8080/stocks/all")
    .map(result => result);
  }
}
