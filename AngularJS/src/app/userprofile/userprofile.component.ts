import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { User } from '../../models/user';
import { UserServiceService } from '../user-service/user-service.service';
import * as moment from 'moment';
import { Route, Router } from '@angular/router'

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {

  userprofile: User;
  error: string;
  name: string = "";
  dateOfBirth: string;
  accountName: string = "";
  password: string = "";
  address: string = "";
  email: string = "";
  gender: number;
  constructor(private router: Router, private userService: UserServiceService) {
  }

  ngOnInit() {
    this.accountName = localStorage.getItem("accountName");
    this.userprofile = new User;

    this.userService.laythongtinnguoidung(this.accountName).pipe(first()).subscribe(res => {
      if (res.success == "true") {
        alert(res.data.name);
        this.userprofile.accountName = res.data.accountName;
        this.userprofile.name = res.data.name;
        this.userprofile.password = res.data.password;
        this.userprofile.phone = res.data.phone;
        this.userprofile.address = res.data.address;
        this.userprofile.email = res.data.email;
        this.userprofile.gender = res.data.gender;
        this.dateOfBirth = moment(res.data.dateOfBirth).format("YYYY-MM-DD").toString();

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
  doithongtincanhan() {
    this.userprofile.dateOfBirth = new Date(this.dateOfBirth);
    this.userService.suathongtinnguoidung(this.userprofile).pipe(first()).subscribe(res => {
      if (res.success = "true") {
        this.accountName = this.userprofile.accountName.toString();
        localStorage.setItem("accountName", this.accountName);
        alert("cap nhat thanh cong");
      }
      else {
        alert("cap nhat khong thanh cong");
      }
    },
      err => {
        alert("cap nat khong thanh cong");
      })
  }

}
