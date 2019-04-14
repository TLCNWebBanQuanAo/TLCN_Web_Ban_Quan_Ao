import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { GuestServiceService } from '../_service/guest-service/guest-service.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-shop-login',
  templateUrl: './shop-login.component.html',
  styleUrls: ['./shop-login.component.css']
})
export class ShopLoginComponent implements OnInit {

  user: User;
  error: string;

  constructor(private router: Router, private guestService: GuestServiceService) { 
    this.user = new User();
  }

  ngOnInit() {
    localStorage.setItem("accountName","");
    localStorage.setItem("role",null);
  }

  login() {
    this.guestService.login(this.user).pipe(first()).subscribe(res => {
  if(res.success == "true"){
    localStorage.setItem("address",res.data.address);
    localStorage.setItem("accountName",res.data.accountName);
    localStorage.setItem("role",res.data.role_id);
    localStorage.setItem("count","0");
    if(res.data.role_id == 1){
      // this.router.navigate(["/adtype"]);
      alert("Admin login successful !!!")
    }
    else{
      // this.router.navigate(["/userprofile"]);
      alert("User login successful !!!")
    }
    
  }else{
    alert("Login unsuccessful !!!");
  }
    
    },
    err=>{
      console.log("login fail: " + err);
      this.error = err;
    })
  }
}
