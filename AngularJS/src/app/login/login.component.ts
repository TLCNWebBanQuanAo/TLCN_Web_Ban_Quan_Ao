import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router'
import { first } from 'rxjs/operators'
import { GuestServiceService } from '../guest-service/guest-service.service';
import { User } from '../../models/user'
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;
  error: string;
  
  constructor(private router: Router, private guestService: GuestServiceService) {
    this.user = new User();
  }

  ngOnInit() {
  if(localStorage.getItem("accountName")!=""){
    this.router.navigate(["/homepage"]);
  }
  else{
    localStorage.setItem("accountName","");
    localStorage.setItem("role",null);
  }
  }
  login() {
    this.guestService.login(this.user).pipe(first()).subscribe(res => {
  if(res.success == "true"){
    localStorage.setItem("accountName",res.data.accountName);
    localStorage.setItem("role",res.data.role_id);
    if(res.data.role_id==1){
      this.router.navigate(["/adtype"]);
    }
    else{
      this.router.navigate(["/userprofile"]);
    }
    
  }else{
    alert("Dang nhap khong thanh cong");
  }
    
    },
    err=>{
      console.log("login fail: "+ err);
      this.error = err;
    })
  }

}
