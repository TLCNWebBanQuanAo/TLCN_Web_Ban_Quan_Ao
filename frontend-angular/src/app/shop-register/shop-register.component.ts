import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { User } from '../../models/user';
import { from } from 'rxjs';
import { first } from 'rxjs/operators';
import { GuestServiceService } from '../_service/guest-service/guest-service.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-shop-register',
  templateUrl: './shop-register.component.html',
  styleUrls: ['./shop-register.component.css']
})
export class ShopRegisterComponent implements OnInit {
  user: User;
  error: string;
  name: string;
  email: string;
  phone: string;
  accountName: string;
  password: string;
  confirmPassword: string;

  constructor(private fb: FormBuilder, private router: Router, private guestService: GuestServiceService) {
    this.user = new User();
    this.user.gender = null;
    this.user.phone = "";
    this.user.status = 1;
    this.user.role_id = 0;
    this.user.dateOfBirth = null;
  }

  ngOnInit() {
    localStorage.clear;
    this.user.accountName = "";
    this.name = "";
    this.email = "";
    this.password = "";
    this.confirmPassword = "";
    this.accountName = "";
    this.phone = "";
  }

  register() {
    if(this.accountName == "" || this.password == "" || this.email == "" || this.phone == "" || this.name == "" || this.confirmPassword == "")
        alert("Please enter full information !!!");
    else{
      if(this.user.password == this.user.confirmpassword){
        this.user.name = this.name;
        this.user.password = this.password;
        this.user.email = this.email;
        this.user.accountName = this.accountName;
        this.user.phone = this.phone;
        this.user.role_id = 0;
        this.guestService.register(this.user).pipe(first()).subscribe(res => {
          alert("Account successfully created !!!");
          this.user.accountName = "";
          this.user.name = "";
          this.user.email = "";
          this.user.password = "";
          this.user.confirmpassword = "";
          this.name = "";
          this.email = "";
          this.password = "";
          this.confirmPassword = "";
          this.accountName = "";
          this.phone = "";
          this.router.navigate(["/login"]);
        
        },
        err=>{
          this.error = err.message;
        })
      }
      else
      alert("Password incorrect !!!");
    }  
  }
}
