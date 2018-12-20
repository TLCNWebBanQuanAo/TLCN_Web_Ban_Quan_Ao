import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';
import { User } from '../../models/user';
import { Router } from '@angular/router';
import { AdminServiceService } from '../admin-service/admin-service.service';
import { from } from 'rxjs';

@Component({
  selector: 'app-aduser',
  templateUrl: './aduser.component.html',
  styleUrls: ['./aduser.component.css']
})
export class AduserComponent implements OnInit {
  // Our array of clients
  users: User[];
  dataTable: any;

  constructor(private chRef: ChangeDetectorRef, private router: Router, private adminservice: AdminServiceService) { }

  ngOnInit() {
    this.adminservice.GetListUser().subscribe(res => {
        this.users = res;

      this.chRef.detectChanges();

      const table: any = $('table');
      this.dataTable = table.DataTable();
    }, err => {
      console.log(err.message)
    });
  }

}
