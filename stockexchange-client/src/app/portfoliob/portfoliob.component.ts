import { Component, OnInit } from '@angular/core';
import {Headers,RequestOptions, Http} from '@angular/http';

import { DataShareService } from '../data-share.service';


@Component({
  selector: 'app-portfoliob',
  templateUrl: './portfoliob.component.html',
  styleUrls: ['./portfoliob.component.css']
})
export class PortfoliobComponent implements OnInit {
bname:string;
getBdetails = [];
  constructor(private data:DataShareService,private http:Http) { }

  ngOnInit() {
    this.data.currentBname.subscribe(bname => this.bname = bname);
     console.log("huuhu"+this.bname);

     var bnameforJ = {
       "broker_name":this.bname
     }


     console.log(bnameforJ);

     let headers = new Headers({ 'Content-Type': 'application/json' });
     let options = new RequestOptions({ headers: headers });
    
       // var body = "username=" + username + "password=" + password;
       console.log(JSON.stringify(bnameforJ));
       this.http.post("http://localhost:8080/broker/portfolio", JSON.stringify(bnameforJ),options).subscribe((data) => {
         console.log(data.json())
           this.getBdetails = data.json()

           console.log(this.getBdetails[0]["price"]);

       });

  }

 

}
