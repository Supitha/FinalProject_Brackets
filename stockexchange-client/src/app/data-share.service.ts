import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataShareService {

private username = new BehaviorSubject<string>("XY");
//This is the one shared across components
currentUname = this.username.asObservable();

  constructor() { }

//UserName detecting function
editUser(uname){
  this.username.next(uname)
}


private brokername = new BehaviorSubject<string>("YZ");
//This is the one shared across 
currentBname = this.brokername.asObservable();


//Brokername detecting function
editBname(bname){
 this.brokername.next(bname)
}
  

}
