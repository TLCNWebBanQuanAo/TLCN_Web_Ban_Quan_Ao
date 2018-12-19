import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { User } from '../../models/user';
import { UserServiceService } from '../user-service/user-service.service';
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
  constructor() {
    this.user = new User;
   }

  ngOnInit() {
    this.user.accountName = localStorage.getItem("accountName");
    this.user.avatar = localStorage.getItem("avatar");
    console.log(this.user.accountName);
  }

}
