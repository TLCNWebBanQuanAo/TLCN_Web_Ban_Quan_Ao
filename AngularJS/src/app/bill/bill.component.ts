import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { Route, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { UserServiceService } from '../user-service/user-service.service';
import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {
  isLogin: boolean;
  isAdminRole: boolean;
  userNameTemp: string;
  accountName:string = "";
  passWord:string = "";
  // Our array of clients
  clients: any[];
  // Our future instance of DataTable
  dataTable: any;
  constructor(private router: Router, private http: HttpClient,
    private chRef: ChangeDetectorRef,
    private userService:UserServiceService) { }

  ngOnInit() {
    this.accountName = localStorage.getItem("accountName");
    this.onInit();
  }
  async onInit(){
    this.userService.getInvoicesByUser(this.accountName).pipe(first())
    .subscribe(res=>{
      this.clients = res.data;

      // You'll have to wait that changeDetection occurs and projects data into 
      // the HTML template, you can ask Angular to that for you ;-)
      this.chRef.detectChanges();

      // Now you can use jQuery DataTables :
      const table: any = $('table');
      this.dataTable = table.DataTable();
    },
    err=>{
    });
  }

}
