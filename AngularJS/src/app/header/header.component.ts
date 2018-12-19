import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { User } from '../../models/user';
import { HeaderService } from '../user-service/header.service';
import * as moment from 'moment';
import { Route, Router } from '@angular/router'
import { FormBuilder ,FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  user: User;
  error: string;
  image:string = "";
  constructor(private router: Router, private headerService: HeaderService,private fb: FormBuilder) {
    this.user = new User;
   }

  ngOnInit() {
    this.user.accountName = localStorage.getItem("accountName");
    console.log(this.user.accountName);
    this.headerService.layavatar(this.user.accountName).pipe(first()).subscribe(res => {
      if (res.success == "true") {
        
        this.image = res.data.avatar;
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
  }

