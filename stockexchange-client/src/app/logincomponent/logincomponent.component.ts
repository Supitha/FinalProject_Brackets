import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { UserService } from '../user.service';

import {HttpModule,Http,Headers,RequestOptions} from '@angular/http';
import { DataShareService } from '../data-share.service';

@Component({
  selector: 'app-logincomponent',
  templateUrl: './logincomponent.component.html',
  styleUrls: ['./logincomponent.component.css']
})
export class LogincomponentComponent implements OnInit {
uname:string;
editUser:string;

  constructor(private router:Router,private user:UserService,private http:Http,private data:DataShareService) { }

  //Didn't put this in to the logincomponent frontend {uname }
  ngOnInit() {
    this.data.currentUname.subscribe(uname => this.uname = uname);
  }


  

  loginUser(e){
   e.preventDefault();
    var username = e.target.elements[0].value;
    var password = e.target.elements[1].value;

     
    if( username == ''  || password == ''){
      this.router.navigate([''])
    }else{

    let user = {
      "username":username,
      "password":password 
    }
    
    //This one passes the username to the editUser() in service
    this.data.editUser(username);

    console.log(username,password);

    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
   
       this.user.setUserLoggedIn()
      // var body = "username=" + username + "password=" + password;
      console.log(JSON.stringify(user));
      this.http.post("http://localhost:8080/user/save", JSON.stringify(user),options).subscribe((data) => {});
       this.router.navigate(['broker-ui'])
    
    return false;
  }}

  
 


}
