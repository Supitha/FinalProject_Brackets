import { Component, OnInit, OnDestroy } from '@angular/core';
import { Http, RequestOptions,Headers } from '@angular/http';
import { DataShareService } from '../data-share.service';

@Component({
  selector: 'app-top-nav',
  templateUrl: './top-nav.component.html',
  styleUrls: ['./top-nav.component.css']
})
export class TopNavComponent implements OnInit, OnDestroy {
  private timer;
  uname:string;

  constructor(private http:Http, private data: DataShareService) { }


  ngOnInit() {
    this.data.currentUname.subscribe(uname => this.uname = uname);
    this.timer = setInterval(() => {
      this.loadbalance();
  }, 1000);
 }
  
 ngOnDestroy() {
  // Will clear when component is destroyed e.g. route is navigated away from.
  clearInterval(this.timer);
}

  number:any


  loadbalance() {
    
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let balance = {
        "username":this.uname
    }
    this.http.post("http://localhost:8080/bank/balance", JSON.stringify(balance),options).
         subscribe((data) => {
           this.number = data.json();
         });
  }

}
