import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { User } from '../../models/user';
import { UserServiceService } from '../user-service/user-service.service';
import * as moment from 'moment';
import { Route, Router } from '@angular/router'
import { FormBuilder ,FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {
  formImage: FormGroup;
  image:string = "";
  userprofile: User;
  error: string;
  name: string = "";
  dateOfBirth: string;
  accountName: string = "";
  password: string = "";
  address: string = "";
  email: string = "";
  gender: number;
  constructor(private router: Router, private userService: UserServiceService,private fb: FormBuilder) {
    this.formImage = this.fb.group({
      name: ['', Validators.required],
      avatar: null
    });
  }

  ngOnInit() {
    this.accountName = localStorage.getItem("accountName");
    this.userprofile = new User;

    this.userService.laythongtinnguoidung(this.accountName).pipe(first()).subscribe(res => {
      if (res.success == "true") {
        this.userprofile.accountName = res.data.accountName;
        this.userprofile.name = res.data.name;
        this.userprofile.password = res.data.password;
        this.userprofile.phone = res.data.phone;
        this.userprofile.address = res.data.address;
        this.userprofile.email = res.data.email;
        this.userprofile.gender = res.data.gender;
        this.dateOfBirth = moment(res.data.dateOfBirth).format("YYYY-MM-DD").toString();
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
  onSaveImage(){
    this.image = this.formImage.get('avatar').value.value;
    this.userprofile.accountName = this.accountName;
    console.log(this.userprofile.accountName);
    this.userprofile.avatar = this.image;
    console.log(this.userprofile.avatar);
    this.userService.changeAvatar(this.userprofile).pipe(first())
    .subscribe(res=>{
      if(res.success == "true")
        alert("Cập nhật ảnh đại diện thành công !!!");
      else
        alert("Cập nhật ảnh đại diện không thành công ???");
    },
    err=>{
        alert("Không cập nhật được ảnh đại diện ???");
    });
  }

  onChangedImage(event){
    let reader = new FileReader();
    if(event.target.files && event.target.files.length > 0) {
      let file = event.target.files[0];
    
      reader.readAsDataURL(file);
       reader.onload = () => {
        this.image = "data:" + file.type + ";base64," + reader.result.split(',')[1];
        this.formImage.get('avatar').setValue({
          filename: file.name,
          filetype: file.type,
          value: "data:" + file.type + ";base64," + reader.result.split(',')[1]
        })
      };
    }
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
