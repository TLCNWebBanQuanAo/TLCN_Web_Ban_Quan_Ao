import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';

import { Type } from '../../models/type';
import { AdminServiceService } from '../admin-service/admin-service.service';
import { Router } from '@angular/router';

import { from } from 'rxjs';

@Component({
  selector: 'app-adtype',
  templateUrl: './adtype.component.html',
  styleUrls: ['./adtype.component.css']
})
export class AdtypeComponent implements OnInit {
  // Our array of clients
  types: Type[];
  dataTable: any;

  constructor(private http: HttpClient, private chRef: ChangeDetectorRef, private router: Router, private adminservice: AdminServiceService) { }

  ngOnInit() {
    this.adminservice.GetListType().subscribe(res => {
      this.types = res;

      this.chRef.detectChanges();

      const table: any = $('table');
      this.dataTable = table.DataTable();
    }, err => {
      console.log(err.message)
    });
  }
}
