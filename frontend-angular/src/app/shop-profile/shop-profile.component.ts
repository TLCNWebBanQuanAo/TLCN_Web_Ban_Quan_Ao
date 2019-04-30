import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { User } from '../../models/user';
import { UserServiceService } from '../_service/user-service/user-service.service';
import * as moment from 'moment';
import { Route, Router } from '@angular/router'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-shop-profile',
  templateUrl: './shop-profile.component.html',
  styleUrls: ['./shop-profile.component.css']
})
export class ShopProfileComponent implements OnInit {
  formImage: FormGroup;
  image: string = "";
  user: User;
  accountName: string;
  error: string;
  dateOfBirth: string;
  password: string;
  newPassword: string;
  reNewPassword: string;

  constructor(private router: Router, private userService: UserServiceService, private fb: FormBuilder) {
    this.user = new User();
    this.formImage = this.fb.group({
      name: ['', Validators.required],
      avatar: null
    });
  }

  ngOnInit() {
    this.accountName = localStorage.getItem("accountName");
    this.userService.laythongtinnguoidung(this.accountName).pipe(first()).subscribe(res => {
      if (res.success == "true") {
        this.user.accountName = res.data.accountName;
        this.user.name = res.data.name;
        this.user.password = res.data.password;
        this.user.phone = res.data.phone;
        this.user.address = res.data.address;
        this.user.email = res.data.email;
        this.user.gender = res.data.gender;
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
    this.user.accountName = this.accountName;
    this.user.avatar = this.image;
    this.userService.changeAvatar(this.user).pipe(first())
    .subscribe(res=>{
      if(res.success == "true"){
        alert("Update your avatar successfully !!!");
        localStorage.setItem("avatar", res.data.avatar);
        window.location.href = "/profile";
      }
        
      else
        alert("Update the avatar failed !!!");
    },
    err=>{
        alert("Can't update the avatar !!!");
    });
  }

  onChangedImage(event) {
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
    this.user.dateOfBirth = new Date(this.dateOfBirth);
    this.userService.suathongtinnguoidung(this.user).pipe(first()).subscribe(res => {
      if (res.success = "true") {
        this.accountName = this.user.accountName.toString();
        localStorage.setItem("accountName", this.accountName);
        alert("Update your information successfully !!!");
      }
      else {
        alert("Update your information failed !!!");
      }
    },
      err => {
        alert("Can't update your information !!!");
      })
  }

  doiMatKhau(){
    this.accountName = localStorage.getItem("accountName");
    if(this.newPassword == this.reNewPassword)
    {
      this.userService.doiMatKhau(this.accountName, this.password, this.newPassword).pipe(first())
      .subscribe(res =>{
          if(res.success == "true")
            alert("Change password successfully !!!");
            window.location.href = "/profile";
      },
      err =>{
          this.error = err.message;
          alert("There was an error while changing the password !!!");
      });
    }
    else{
      this.error = "Confirm new password is not correct !!!"
    }
  }

}
