import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Type } from '../../models/type';
import { AdminServiceService } from '../admin-service/admin-service.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';

@Component({
  selector: 'app-adtype',
  templateUrl: './adtype.component.html',
  styleUrls: ['./adtype.component.css']
})
export class AdtypeComponent implements OnInit {
  // Our array of clients
  types: Type[];
  dataTable: any;
  type: Type;
  isClick: boolean = false;
  editTypeName: string;

  constructor(private http: HttpClient, private chRef: ChangeDetectorRef, private router: Router, private adminservice: AdminServiceService) { }

  ngOnInit() {
    this.getAllType();
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
      alert("Chưa chọn loại sản phẩm cần cập nhật !!!");
    }
    else {
      this.type.name = this.editTypeName;
      this.adminservice.updateType(this.type).pipe(first()).subscribe(res => {
        this.getAllType();
        alert("Cập nhật loại sản phẩm thành công !!!");
      },
        err => {
          this.getAllType();
          alert("Cập nhật loại sản phẩm không thành công !!!");
        })
    }
  }
}
