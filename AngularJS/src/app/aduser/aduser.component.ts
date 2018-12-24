import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../../models/user';
import { AdminServiceService } from '../admin-service/admin-service.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';

@Component({
  selector: 'app-aduser',
  templateUrl: './aduser.component.html',
  styleUrls: ['./aduser.component.css']
})
export class AduserComponent implements OnInit {
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
      this.router.navigate(["/homepage"]);
    }
  }

  load() {
    this.adminservice.GetListUser().subscribe(res => {
      this.users = res;

      for(let user of this.users)
      {
        if(user.status == 1){
          user.isActive = "Bỏ Kích Hoạt"
        }
        else if(user.status == 2){
          user.isActive = "Kích Hoạt"
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
