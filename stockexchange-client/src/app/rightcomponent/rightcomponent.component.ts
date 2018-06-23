import { Component, OnInit,HostListener } from '@angular/core';
import { DataShareService } from '../data-share.service';

import { HttpClient } from '@angular/common/http';

import {HttpModule,Http,Headers,RequestOptions} from '@angular/http';


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

uname:string;
stock_names = [];
bname:string;
full_json_array = [];
isLoadbalance: boolean;

  constructor(private data:DataShareService, private _http:HttpClient,private http:Http) {
    this.data.isLoadbalance.subscribe( value => {
      this.isLoadbalance = value;
  });
   }

  ngOnInit() {
    this.loadDetailstoDropdown();
    this.data.currentUname.subscribe(uname => this.uname = uname);
    //In here user takes the uname.
    console.log(this.uname);
    this.full_json_array.push(this.uname)


    this.data.currentBname.subscribe(bname => this.bname = bname);

    //In here broker takes the bname.
    console.log(this.bname);
    this.full_json_array.push(this.bname);

    console.log(this.full_json_array);
    
  }

//   submitPForm(e) {
//     var price = e.target.elements[0].value;
//     this.full_json_array.push(price);
//     console.log(price);
// }



  loadDetailstoDropdown(){
    return this._http.get("http://localhost:8080/stocks/all")
    .subscribe(
     (data:any[]) => this.stock_names = data
    )
  }


  onSelected(e){
    this.full_json_array.push(e);
console.log(this.full_json_array);
  }
  

  // submitQForm(e){
  //   var quantiy = e.target.elements[0].value;
  //   this.full_json_array.push(quantiy);
  //   console.log(quantiy);

  //   console.log(JSON.stringify(this.full_json_array));
  //   this.convertToJsonObj();
  // }



  // convertToJsonObj(){
  //   var cusName =this.full_json_array[0];
  //   var broker_name = this.full_json_array[1];
  //   var stock = this.full_json_array[2];
  //   var quantiy = this.full_json_array[3];

   
  //   let array_Details = {
  //      "cusName" : cusName,
  //      "broker_name":broker_name,
  //      "stock":stock,
  //      "quantity": quantiy
  //   }
    
  //   return array_Details;
  //   // console.log(array_Details);
  // }


  // buyButton(){
  //   var array_Details = this.convertToJsonObj();

  //   let headers = new Headers({ 'Content-Type': 'application/json' });
  //   let options = new RequestOptions({ headers: headers });
  //   this.http.post("http://localhost:8080/broker/qty", JSON.stringify(array_Details),options).subscribe((data) => {
  //   });
  
  // }

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
    // var stock = this.onSelected(e);
    // console.log(stock);
    //  var quantity =  e.target.elements[0].value;
   // console.log(quantity);

  

    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
<<<<<<< Updated upstream
    this.http.post("http://localhost:8080/broker/qty", JSON.stringify(array_Details),options).subscribe((data) => {
      this.data.isLoadbalance.next(true);
=======
    this.http.post("http://localhost:8080/broker/qty", JSON.stringify(array_model),options).subscribe((data) => {
>>>>>>> Stashed changes
    });
  
  

  }



  formSSubmit(){
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
    // var stock = this.onSelected(e);
    // console.log(stock);
    //  var quantity =  e.target.elements[0].value;
   // console.log(quantity);

  

    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    this.http.post("http://localhost:8080/broker/sell", JSON.stringify(array_model),options).subscribe((data) => {
    });
  
  
  }

}
