import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';
import { Product } from '../../models/product';
import { AdminServiceService } from '../_service/admin-service/admin-service.service';
import { first } from 'rxjs/operators';
import { Route } from '@angular/router';

@Component({
  selector: 'app-ad-listproduct',
  templateUrl: './ad-listproduct.component.html',
  styleUrls: ['./ad-listproduct.component.css']
})
export class AdListproductComponent implements OnInit {

  // Our array of clients
  products: Product[];
  dataTable: any;
  trangthai: string;
  trangthaiBan: string;
  role: string;

  constructor(private http: HttpClient, private chRef: ChangeDetectorRef ,private router: Router, private adminservice: AdminServiceService) { }

  ngOnInit() {
    this.role= localStorage.getItem("role");
    if(this.role=="1"){
      this.getAllProduct();
    }else{
      this.router.navigate(["/"]);
    }
  }

  getAllProduct() {
    this.adminservice.GetListProduct().subscribe(res => {
      this.products = res;

      for(let product of this.products)
      {
        if(product.status == 1){
         product.trangthai = "Are selling";
         product.trangthaiBan = "Out of stock";
        }
        else if(product.status == 0){
          product.trangthai = "Out of stock";
          product.trangthaiBan = "Back in stock";
        }
      }

      this.chRef.detectChanges();

      const table: any = $('table');
      this.dataTable = table.DataTable();
    }, err => {
      console.log(err.message)
    });
  }

  onEditStatus(id: number){
    this.adminservice.updateStatusProduct(id)
      .pipe(first())
      .subscribe(res => {
        this.getAllProduct()
      }, err => {
        this.getAllProduct()
        console.log(err);
      })  

  }
  addProduct(){
    window.location.href = "/ad-adproduct";
  }

}
