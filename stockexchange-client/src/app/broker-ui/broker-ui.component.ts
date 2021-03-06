import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import { DataShareService } from '../data-share.service';



@Component({
  selector: 'app-broker-ui',
  templateUrl: './broker-ui.component.html',
  styleUrls: ['./broker-ui.component.css']
})
export class BrokerUIComponent implements OnInit {
  brokers = [];
  bname :string;
  flag = false;

  constructor(private _http:HttpClient,private router:Router,private data:DataShareService) {
  
   }

  ngOnInit() {
    this.data.currentUname.subscribe(bname => this.bname = bname);

    this.load_broker_list();
  }


  load_broker_list(){
   return this._http.get("http://localhost:8080/broker/all")
                     .subscribe(
                      (data:any[]) => this.brokers = data
                     )
  }

  fullPage(){
    if (!this.flag) {
      alert("Please select a Broker");
      this.router.navigateByUrl('broker-ui');
    } else{
      this.router.navigateByUrl('fullpage') 
     }
  }
    

    onSelect(broker){
      this.flag = true;
      this.data.editBname(broker.username);

      console.log(broker.username);
    }

}
