import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Type } from '../../models/type';
import { AdminServiceService } from '../_service/admin-service/admin-service.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';


@Component({
  selector: 'app-ad-listtype',
  templateUrl: './ad-listtype.component.html',
  styleUrls: ['./ad-listtype.component.css']
})
export class AdListtypeComponent implements OnInit {

  types: Type[];
  dataTable: any;
  type: Type;
  isClick: boolean = false;
  editTypeName: string;
  role:string ; 

  constructor(private http: HttpClient, private chRef: ChangeDetectorRef, private router: Router, private adminservice: AdminServiceService) { }

  ngOnInit() {
    this.role= localStorage.getItem("role");
    if(this.role=="1"){
      this.getAllType();
    }else{
      this.router.navigate(["/homepage"]);
    }
  }

  getAllType() {
    this.adminservice.GetListType().subscribe(res => {
      this.types = res;

      this.chRef.detectChanges();

      const table: any = $('table');
      this.dataTable = table.DataTable();
    }, err => {
      console.log(err.message)
    });
  }

  onGotoTypeEdit(id) {
    this.isClick = true;
    for (let type1 of this.types) {
      if (type1.id == id) {
        this.type = type1;
        this.editTypeName = type1.name;
      }
    }
  }

  updateType() {
    if (this.isClick == false) {
      alert("Not selected product type to update !!!");
    }
    else {
      this.type.name = this.editTypeName;
      this.adminservice.updateType(this.type).pipe(first()).subscribe(res => {
        this.getAllType();
        alert("Update the product type successfully.");
      },
        err => {
          this.getAllType();
          alert("Update product type failed !!!");
        })
    }
  }

  cancle() {
    this.editTypeName = "";
    this.type.name = this.editTypeName;
  }

}
