import { Component, OnInit,HostListener } from '@angular/core';
import { DataShareService } from '../data-share.service';

import { HttpClient } from '@angular/common/http';

import {Http,Headers,RequestOptions} from '@angular/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-rightcomponent',
  templateUrl: './rightcomponent.component.html',
  styleUrls: ['./rightcomponent.component.css']
})
export class RightcomponentComponent implements OnInit {
  //Avoid page reoload
  @HostListener("window:beforeunload", ["$event"]) unloadHandler(event: Event) {
    console.log("Processing beforeunload...");
    event.returnValue = false;
}

count:number = 0;
uname:string;
stock_names = [];
bname:string;
full_json_array = [];
private timer;

getBdetails = [];

  constructor(private data:DataShareService, private _http:HttpClient,private http:Http,private router:Router) {}

  ngOnInit() {
    
    this.data.currentUname.subscribe(uname => this.uname = uname);
    //In here user takes the uname.
    console.log(this.uname);
    this.full_json_array.push(this.uname)


    this.data.currentBname.subscribe(bname => this.bname = bname);

    //In here broker takes the bname.
    console.log(this.bname);
    this.full_json_array.push(this.bname);
    console.log(this.full_json_array);
    this.loadDetailstoDropdown();
    
  }


  loadDetailstoDropdown(){
  
    var bnameforJ = { 
      "broker_name":this.bname
    }

    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.post("http://localhost:8080/broker/brokerall", JSON.stringify(bnameforJ),options).subscribe((data) => {
                this.stock_names = data.json();
          });
  }


  onSelected(e){
    this.full_json_array.push(e);
console.log(this.full_json_array);
  }
  



   Model = {
    stockname: '',
    quantity: ''
}

  formBSubmit(){
 
    var cusName = this.uname;
    var broker_name = this.bname;
    var stock = this.Model.stockname;
    var quantity = this.Model.quantity;
   
    let array_model = {
      "cusName" : cusName,
      "broker_name" : broker_name,
      "stock" : stock,
      "quantity":quantity

    }

    console.log(array_model);
  


    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    this.http.post("http://localhost:8080/broker/buy", JSON.stringify(array_model),options).subscribe((data) => {
      alert(data.text());
    });
  
  
     this.clickCount();
  }



  formSSubmit(){
    var cusName = this.uname;
    var broker_name = this.bname;
    var stock = this.Model.stockname;
    var quantity = this.Model.quantity;
   
    let array_model = {
      "customer_name" : cusName,
      "broker_name" : broker_name,
      "stocks" : stock,
      "quantity":quantity

    }

    console.log(array_model);
   

    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    this.http.post("http://localhost:8080/broker/sell", JSON.stringify(array_model),options).subscribe((data) => {
      alert(data.text());
    });
  
  this.clickCount();
  }

  clickCount(){
    this.count++
    console.log(this.count);
    if(this.count == 6){
      alert("Game Over, You have tried all of your chances, Now go to leaderboard");
      this.router.navigateByUrl('fullpage/leaderBoard');
    }
  }

}
