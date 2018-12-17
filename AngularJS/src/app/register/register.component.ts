import { Route, Router } from '@angular/router'
import { User } from '../../models/user'
import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { first } from 'rxjs/operators'
import { GuestServiceService } from '../guest-service/guest-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User;
  error: string;
  constructor(private router: Router, private guestService: GuestServiceService) {
    this.user = new User();
    this.user.gender = 1;
    this.user.phone = 1;
    this.user.status = "1";
    this.user.avatar = "";
    this.user.dateOfBirth = null;

  }

  ngOnInit() {
  }
  register() {
    this.guestService.register(this.user).pipe(first()).subscribe(res => {
      alert("Tao thanh cong");
      this.user.accountName = "";
      this.user.name = "";
      this.user.email = "";
      this.user.password = "";
      this.user.confirmpassword = "";
    
    },
    err=>{
      this.error = err.message;
    })
  }
}
