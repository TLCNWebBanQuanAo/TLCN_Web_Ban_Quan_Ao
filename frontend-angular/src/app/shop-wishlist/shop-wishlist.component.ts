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
  selector: 'app-shop-wishlist',
  templateUrl: './shop-wishlist.component.html',
  styleUrls: ['./shop-wishlist.component.css']
})
export class ShopWishlistComponent implements OnInit {

  clients: any[];
  dataTable: any;
  error: string;
  size: string;
  product: Product;
  accountName: string = "";
  temp = 0;
  dealPrice: number = 0;
  phone: number = 0;
  tong: number = 0;
  addScript: boolean = false;
  paypalLoad: boolean = true;
  finalAmount: number = 1;

  constructor(private http: HttpClient, private router: Router, private userService: UserServiceService, private fb: FormBuilder) { }

  ngOnInit() {
    this.accountName = localStorage.getItem("accountName");
    this.userService.getProductInWishList(this.accountName).pipe(first())
      .subscribe(res => {
        this.clients = res.data;
      });
  }

  deleteProductInWishlist(productId: number) {
    this.userService.deleteProductInWishList(this.accountName.toString(), productId).pipe(first())
      .subscribe(res => {
        if (res.success == "true") {
         
          this.clients.forEach(product => {
            console.log(product);
            if (product.productId == productId) {
              this.clients.splice(this.temp, 1);
              return;
            }
            this.temp++;
          });
        }
        else
          alert("Không bỏ sản phẩm ra khỏi wishlist được !!!");
      },
        err => {
          alert("Không bỏ sản phẩm ra khỏi wishlist được !!!");
        });
  }

}
