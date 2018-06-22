import { Component, OnInit } from '@angular/core';
import { DataShareService } from '../data-share.service';

@Component({
  selector: 'app-rightcomponent',
  templateUrl: './rightcomponent.component.html',
  styleUrls: ['./rightcomponent.component.css']
})
export class RightcomponentComponent implements OnInit {
uname:string;
  constructor(private data:DataShareService) { }

  ngOnInit() {
    this.data.currentUname.subscribe(uname => this.uname = uname);
    //In here user takes the uname.
    console.log(this.uname);
  }

}
