import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';
import { first } from 'rxjs/operators';
import { User } from '../../models/user';
import { UserServiceService } from '../_service/user-service/user-service.service';
import * as moment from 'moment';
import { Route, Router } from '@angular/router'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Product } from '../../models/product';
import { from } from 'rxjs';
import { isNumber } from 'util';
declare let paypal: any;

@Component({
  selector: 'app-shop-checkout',
  templateUrl: './shop-checkout.component.html',
  styleUrls: ['./shop-checkout.component.css']
})
export class ShopCheckoutComponent implements OnInit {
  clients: any[];
  dataTable: any;
  error: string;
  size: string;
  product: Product;
  accountName: string = "";
  temp = 0;
  diaChiGiaoHang: string;
  phone: string;
  tong: number = 0;
  addScript: boolean = false;
  paypalLoad: boolean = true;
  finalAmount: number = 1;

  constructor(private http: HttpClient, private router: Router, private userService: UserServiceService, private fb: FormBuilder) { }

  ngOnInit() {
    this.accountName = localStorage.getItem("accountName");

    this.userService.laythongtinnguoidung(this.accountName).pipe(first()).subscribe(res => {
      if (res.success == "true") {
        this.diaChiGiaoHang = res.data.address;
      }
    },
      err => {
        console.log("login fail: " + err);
        this.error = err;
      })

    this.userService.laythongtingiohang(this.accountName).pipe(first())
      .subscribe(res => {
        this.clients = res.data;
        for (let i = 0; i < this.clients.length; i++) {
          this.tong += this.clients[i].price * this.clients[i].quantity;
        }
      });
  }

  async thanhtoan(status: number) {
    await this.userService.thanhToan(this.accountName, this.diaChiGiaoHang, this.tong, status).pipe(first())
      .subscribe(res => {
        if (res == true) {
          this.clients = null;
          this.diaChiGiaoHang = "";
          this.tong = 0;
           alert("Thanh toán thành công !!!");
        }
        else
          alert("Thanh toán không thành công !!!");
      },
        err => {
          alert("Hiện tại không thể thanh toán !!!");
        });
  }

}
