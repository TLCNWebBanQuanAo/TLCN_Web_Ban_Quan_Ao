import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';
import { User } from '../../models/user';
import { Router } from '@angular/router';
import { AdminServiceService } from '../admin-service/admin-service.service';
import { from } from 'rxjs';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-aduser',
  templateUrl: './aduser.component.html',
  styleUrls: ['./aduser.component.css']
})
export class AduserComponent implements OnInit {
  // Our array of clients
  users: User[];

  dataTable: any;
  kichhoat: string;
  roleChange: string;

  constructor(private chRef: ChangeDetectorRef, private router: Router, private adminservice: AdminServiceService) { }

  ngOnInit() {
    this.load();
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
