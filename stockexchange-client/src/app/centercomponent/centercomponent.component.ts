import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { HelperService } from '../helper.service';


import {Chart} from 'chart.js';

@Component({
  selector: 'app-centercomponent',
  templateUrl: './centercomponent.component.html',
  styleUrls: ['./centercomponent.component.css']
})
export class CentercomponentComponent implements OnInit {
stock_details = [];

chart = [];

  constructor(private _http:HttpClient, private _graph:HelperService) { }

  ngOnInit() {
    this.load_stock_details();


    this._graph.getGraphData()
    .subscribe(res => {
      console.log(res[0]);
      
     let stock_price = [];

      for(let i=0; i <= 5; i++){
         stock_price.push( res[i].price);
        
      }
      console.log(stock_price);
  
      let timeloop=[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22];
     


     this.chart = new Chart('canvas',{
       type:'line',
       data: {
         labels:timeloop,
         datasets: [
         
           {
            data:stock_price,
            borderColor:'#ffcc00',
            fill:false
          }
         ]
       },
       options:{
         legend:{
           display:false
         },
         scales: {
          xAxes: [{
            display:true
          }],
           yAxes: [{
             display:true
           }]
         }
       }
     })

    })

   

  }

  load_stock_details(){
    return this._http.get("http://localhost:8080/stocks/all")
                     .subscribe(
                      (data:any[]) => this.stock_details = data
                     )
  }

}
