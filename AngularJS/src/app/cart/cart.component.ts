import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';
import { first } from 'rxjs/operators';
import { User } from '../../models/user';
import { UserproductService } from '../user-service/userproduct.service';
import * as moment from 'moment';
import { Route, Router } from '@angular/router'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Product } from 'src/models/product';
import { CartService } from '../user-service/cart.service'
import { from } from 'rxjs';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  clients: any[];
  dataTable: any;
  error: string;
  product: Product;
  accountName: string = "";
  temp = 0;
  diaChiGiaoHang: string = "";
  tong: number = 0;
  constructor(private http: HttpClient, private chRef: ChangeDetectorRef, private router: Router, private UserproductService: UserproductService, private fb: FormBuilder, private cartService: CartService) { }

  ngOnInit() {
    this.accountName = localStorage.getItem("accountName");

    this.UserproductService.laythongtingiohang(this.accountName).pipe(first())
      .subscribe(res => {
        this.clients = res.data;
        for (let i = 0; i < this.clients.length; i++) {
          this.tong += this.clients[i].price * this.clients[i].quantity;
        }
        // You'll have to wait that changeDetection occurs and projects data into 
        // the HTML template, you can ask Angular to that for you ;-)
        this.chRef.detectChanges();

        // Now you can use jQuery DataTables :
        const table: any = $('table');
        this.dataTable = table.DataTable();
      });

  }
  clearCart() {
    this.cartService.deleteAllProductInCart(this.accountName.toString()).pipe(first())
      .subscribe(res => {
        if (res == true) {
          this.clients = null;
          this.tong= 0;
          alert("Làm mới giỏ hàng !!!");
        }
      },
        err => {

        });
  }
  deleteProductInCart(productId: number) {
    this.cartService.deleteProductInCart(this.accountName.toString(), productId).pipe(first())
      .subscribe(res => {
        if (res.success == "true") {
          this.clients.forEach(product => {
            if (product.product_id == productId) {
              this.clients.splice(this.temp, 1);
              this.tong -= product.price*product.quantity;
              return;
            }
            this.temp++;
          });
        }
        else
          alert("Không bỏ sản phẩm ra khỏi giỏ hàng được !!!");
      },
        err => {
          alert("Không bỏ sản phẩm ra khỏi giỏ hàng được !!!");
        });
  }
  async thanhtoan() {
    await this.cartService.thanhToan(this.accountName, this.diaChiGiaoHang, this.tong).pipe(first())
      .subscribe(res => {
        if (res == true) {
          this.clients = null;
          this.diaChiGiaoHang = "";
          this.tong = 0;
          alert("Thanh toán thành công !!!");
        }
        else
          alert("Thanh toán không thành công ???");
      },
        err => {
          alert("Hiện tại không thể thanh toán ???");
        });
  }
}
