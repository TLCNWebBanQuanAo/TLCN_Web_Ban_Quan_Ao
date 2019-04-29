import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/user';
import { Router } from '@angular/router';
import { UserServiceService } from '../_service/user-service/user-service.service';
import { FormBuilder } from '@angular/forms';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-shop-header',
  templateUrl: './shop-header.component.html',
  styleUrls: ['./shop-header.component.css']
})
export class ShopHeaderComponent implements OnInit {
  user: User;
  username: string;
  error: string;
  image: string;
  constructor(private router: Router, private userService: UserServiceService, private fb: FormBuilder) {
    this.user = new User;
   }

  ngOnInit() {
    this.user.accountName = localStorage.getItem("accountName");
    this.username = this.user.accountName;
    this.userService.layavatar(this.user.accountName).pipe(first()).subscribe(res => {
      if (res.success == "true") {
        this.image = res.data.avatar;
        if(this.image == null){                   
          this.image = "/assets/divisima/img/profile.png";
        }
      }
      else {
        location.href = "/login";
      }
    },
      err => {
        console.log("login fail: " + err);
        this.error = err;
      })
  }

  onLogout(){
    localStorage.clear()
    window.location.href = "/login";
  }

  gotoChangePassword(){
    window.location.href = "";
  }

}
