import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-logincomponent',
  templateUrl: './logincomponent.component.html',
  styleUrls: ['./logincomponent.component.css']
})
export class LogincomponentComponent implements OnInit {

  constructor(private router:Router,private user:UserService) { }

  ngOnInit() {
  }

  loginUser(e){

    var username = e.target.elements[0].value;
    var password = e.target.elements[1].value;
    console.log(username,password);
    if(username =="player" && password =="players"){
      this.user.setUserLoggedIn()
       this.router.navigate(['fullpage'])
    }
    return false;
  }

}
