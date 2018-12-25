import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';
import { Product } from 'src/models/product';
import { AdminServiceService } from '../admin-service/admin-service.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-adproduct',
  templateUrl: './adproduct.component.html',
  styleUrls: ['./adproduct.component.css']
})
export class AdproductComponent implements OnInit {

  // Our array of clients
  products: Product[];
  dataTable: any;
  trangthai: string;
  trangthaiBan: string;

  constructor(private http: HttpClient, private chRef: ChangeDetectorRef, private adminservice: AdminServiceService) { }

  ngOnInit() {
    this.getAllProduct();
  }

  getAllProduct() {
    this.adminservice.GetListProduct().subscribe(res => {
      this.products = res;

      for(let product of this.products)
      {
        if(product.status == 1){
         product.trangthai = "Còn bán";
         product.trangthaiBan = "Ngừng bán";
        }
        else if(product.status == 0){
          product.trangthai = "Ngưng bán";
          product.trangthaiBan = "Mở bán lại";
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

}
