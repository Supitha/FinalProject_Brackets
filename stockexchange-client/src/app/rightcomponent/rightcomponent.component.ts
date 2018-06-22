import { Component, OnInit } from '@angular/core';
import { DataShareService } from '../data-share.service';

@Component({
  selector: 'app-rightcomponent',
  templateUrl: './rightcomponent.component.html',
  styleUrls: ['./rightcomponent.component.css']
})
export class RightcomponentComponent implements OnInit {
uname:string;

bname:string;
full_json_array = [];
  constructor(private data:DataShareService) { }

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
    
  }

  submitPForm(e) {
    var price = e.target.elements[0].value;
    this.full_json_array.push(price);
    console.log(price);
}

  submitQForm(e){
    var quantiy = e.target.elements[0].value;
    this.full_json_array.push(quantiy);
    console.log(quantiy);

    console.log(this.full_json_array);
  }





}
