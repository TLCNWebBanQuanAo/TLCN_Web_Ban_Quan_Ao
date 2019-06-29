import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../../models/user';
import { AdminServiceService } from '../_service/admin-service/admin-service.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';

@Component({
  selector: 'app-ad-listuser',
  templateUrl: './ad-listuser.component.html',
  styleUrls: ['./ad-listuser.component.css']
})
export class AdListuserComponent implements OnInit {

  // Our array of clients
  users: User[];
  dataTable: any;
  user: User;
  isClick: boolean = false;
  editRole: number;
  role:string ; 
  kichhoat: string;

  constructor(private http: HttpClient, private chRef: ChangeDetectorRef, private router: Router, private adminservice: AdminServiceService) { }

  ngOnInit() {
    this.role= localStorage.getItem("role");
    if(this.role=="1"){
      this.load();
    }else{
      this.router.navigate(["/"]);
    }
  }

  load() {
    this.adminservice.GetListUser().subscribe(res => {
      this.users = res;

      for(let user of this.users)
      {
        if(user.status == 1){
          user.isActive = "Admin"
        }
        else if(user.status == 2){
          user.isActive = "User"
        }
      }

      this.chRef.detectChanges();

      const table: any = $('table');
      this.dataTable = table.DataTable();
    }, err => {
      console.log(err.message)
    });
  }

  onSetStatus(id: number){
    this.adminservice.updateStatusUser(id)
      .pipe(first())
      .subscribe(res => {
        this.load();
      }, err => {
        this.load();
        console.log(err);
      })  

  }

}
