import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-centercomponent',
  templateUrl: './centercomponent.component.html',
  styleUrls: ['./centercomponent.component.css']
})
export class CentercomponentComponent implements OnInit {
stock_details = [];
  constructor(private _http:HttpClient) { }

  ngOnInit() {
    this.load_stock_details();
  }

  load_stock_details(){
    return this._http.get("http://localhost:8080/stocks/all")
                     .subscribe(
                      (data:any[]) => this.stock_details = data
                     )
  }

}
