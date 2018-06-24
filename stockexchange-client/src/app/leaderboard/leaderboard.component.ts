import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

import { DataShareService } from '../data-share.service';



@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {
leaders = [];
uname:string;
  constructor(private _http:HttpClient, private data:DataShareService) { }

  ngOnInit() {

    this.data.currentUname.subscribe(uname => this.uname = uname);

   console.log("This is from",this.uname);
    return this._http.get("http://localhost:8080/bank/list")
    .subscribe(
     (data:any[]) => this.leaders = data
    )
  }

}
