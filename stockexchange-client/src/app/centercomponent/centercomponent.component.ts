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

private timer;

  constructor(private _http:HttpClient, private _graph:HelperService) { }

  ngOnInit() {
    
    setInterval(()=>{
      this.load_stock_details();
    },5000)

    this.drawGraph();
    
    setInterval(()=>{
      this.drawGraph();
   },5000);

  }

  drawGraph(){
    this._graph.getGraphData()
    .subscribe(res => {
     
      
     let stock_price = [];

      for(let i=1; i <= 19; i++){
         stock_price.push( res[i].price);
        
      }
      console.log(stock_price);
  
           let timeloop=["google","amazon","hooli","apple","stark","wayne","wb","delos","fox","nasa","fedex","dhl","sony","jvc","oracle","rk","dk","yahoo"];



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
    // return this._http.get("http://localhost:8080/stocks/all")
    //                  .subscribe(
    //                   (data:any[]) => this.stock_details = data
    //                  )
    return this._graph.getGraphData()
                    .subscribe(
                    (data:any[]) => this.stock_details = data)

  }


  

}
