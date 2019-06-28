import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { Route, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AdminServiceService } from '../_service/admin-service/admin-service.service';
import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-ad-listorder',
  templateUrl: './ad-listorder.component.html',
  styleUrls: ['./ad-listorder.component.css']
})
export class AdListorderComponent implements OnInit {
  userNameTemp: string;
  accountName: string = "";
  passWord: string = "";
  clients: any[];
  dataTable: any;

  constructor(private router: Router, private chRef: ChangeDetectorRef, private http: HttpClient, private adminService: AdminServiceService) { }

  ngOnInit() {
    this.onInit();
  }

  onInit() {
    this.accountName = localStorage.getItem("accountName");
    this.adminService.getAllOrder().pipe(first())
      .subscribe(res => {
        this.clients = res.data;
        this.chRef.detectChanges();
        const table: any = $('table');
        this.dataTable = table.DataTable({
          "order": [[6, "desc"]]
        });
      },
        err => {
        });
  }

  onGotoDetail(id) {
    window.location.href = "/orderdetail/" + id;
  }

  onSetStatus(id: number) {
    for (let client of this.clients) {
      if (client.bill_id == id) {
        client.status = 1;
      }
    }
    this.adminService.setStatus(id, this.accountName)
      .pipe(first())
      .subscribe(res => {
      }, err => {
      })
  }
}