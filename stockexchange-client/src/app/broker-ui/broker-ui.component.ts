import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';



@Component({
  selector: 'app-broker-ui',
  templateUrl: './broker-ui.component.html',
  styleUrls: ['./broker-ui.component.css']
})
export class BrokerUIComponent implements OnInit {
  brokers = [];

  constructor(private _http:HttpClient,private router:Router) {
  
   }

  ngOnInit() {
    this.load_broker_list();
  }


  load_broker_list(){
   return this._http.get("http://localhost:8080/broker/all")
                     .subscribe(
                      (data:any[]) => this.brokers = data
                     )
  }

  fullPage(){
    console.log("Clicked");
    this.router.navigateByUrl('fullpage')  }

}
