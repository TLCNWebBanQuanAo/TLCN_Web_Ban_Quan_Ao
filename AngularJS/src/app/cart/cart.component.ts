import { Component, OnInit, ChangeDetectorRef, AfterViewChecked } from '@angular/core';
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
import { isNumber } from 'util';
declare let paypal: any;
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
  phone: number = 0;
  tong: number = 0;
  addScript: boolean = false;
  paypalLoad: boolean = true;
  finalAmount: number = 1;
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
  async thanhtoan(status: number) {
    await this.cartService.thanhToan(this.accountName, this.diaChiGiaoHang, this.tong, status).pipe(first())
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
  paypalConfig = {
    env: 'sandbox',
    client: {
      sandbox: 'AaA2r4L0yM1IMIR1mXkOXggEQyiyyJpYDrJAjNB2pjrB59sAnvM_u7qc6iBtV-1_WIaod6mdb3h5wwGJ',
      production: 'EPt6FS3URTzAd9dfRXvIYuvxSch6tB6QUS172ZN4PSfupifsGc7I8YQWgNeM3iN-PBG-PYzxaHtM7dq0'
    },
    commit: true,
    payment: (data, actions) => {
      return actions.payment.create({
        payment: {
          transactions: [
            { amount: { total: this.tong, currency: 'USD' } }
          ]
        }
      });
    },
    onAuthorize: (data, actions) => {
      return actions.payment.execute().then((payment) => {
        this.thanhtoan(1);
      })
    }
  };
 
  ngAfterViewChecked(): void {
    if (!this.addScript) {
      this.addPaypalScript().then(() => {
        paypal.Button.render(this.paypalConfig, '#paypal-checkout-btn');
        this.paypalLoad = false;
      })
    }
  }
  
  addPaypalScript() {
    this.addScript = true;
    return new Promise((resolve, reject) => {
      let scripttagElement = document.createElement('script');    
      scripttagElement.src = 'https://www.paypalobjects.com/api/checkout.js';
      scripttagElement.onload = resolve;
      document.body.appendChild(scripttagElement);
    })
  }
  plusProductInCart(id: number, quantity: number){
    this.accountName = localStorage.getItem("accountName");
      this.cartService.plusProductInCart(this.accountName, id, quantity)
      .pipe(first()).subscribe(res=>{
        if(res.success == "true"){
          this.clients.forEach(product => {
            if (product.product_id == res.data.product_id) {
              product.quantity= product.quantity +1;
              this.tong= this.tong + product.price;
              return;
            }
          });
        }
      },
      err=>{
  
      }); 
  }
  minusProductInCart(id: number, quantity: number){
    this.accountName = localStorage.getItem("accountName");
      this.cartService.minusProductInCart(this.accountName, id, quantity)
      .pipe(first()).subscribe(res=>{
        if(res.success == "true"){
          this.clients.forEach(product => {
            if (product.product_id == res.data.product_id) {
              product.quantity= product.quantity-1;
              this.tong= this.tong - product.price;
              return;
            }
          });
        }
      },
      err=>{
  
      }); 
  }
}
