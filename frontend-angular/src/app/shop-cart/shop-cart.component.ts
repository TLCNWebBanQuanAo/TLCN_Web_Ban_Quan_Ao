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
  selector: 'app-shop-cart',
  templateUrl: './shop-cart.component.html',
  styleUrls: ['./shop-cart.component.css']
})
export class ShopCartComponent implements OnInit {
  clients: any[];
  dataTable: any;
  error: string;
  size: string;
  product: Product;
  accountName: string = "";
  temp = 0;
  diaChiGiaoHang: string = "";
  phone: number = 0;
  tong: number = 0;
  addScript: boolean = false;
  paypalLoad: boolean = true;
  finalAmount: number = 1;

  constructor(private http: HttpClient, private router: Router, private userService: UserServiceService, private fb: FormBuilder) { }

  ngOnInit() {
    this.accountName = localStorage.getItem("accountName");
    this.userService.laythongtingiohang(this.accountName).pipe(first())
      .subscribe(res => {
        this.clients = res.data;
        for (let i = 0; i < this.clients.length; i++) {
          this.tong += this.clients[i].price * this.clients[i].quantity;
        }
      });
  }

  clearCart() {
    this.userService.deleteAllProductInCart(this.accountName.toString()).pipe(first())
      .subscribe(res => {
        if (res == true) {
          this.clients = null;
          this.tong= 0;
          alert("Refresh the shopping cart !!!");
        }
      },
        err => {

        });
  }

  checkout() {
    window.location.href = "/checkout";
  }

  deleteProductInCart(productId: number) {
    this.userService.deleteProductInCart(this.accountName.toString(), productId).pipe(first())
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
          alert("Do not remove the product from the cart !!!");
      },
        err => {
          alert("Do not remove the product from the cart !!!");
        });
  }
  async thanhtoan(status: number) {
    await this.userService.thanhToan(this.accountName, this.diaChiGiaoHang, this.tong, status).pipe(first())
      .subscribe(res => {
        if (res == true) {
          this.clients = null;
          this.diaChiGiaoHang = "";
          this.tong = 0;
           alert("Payment success.");
        }
        else
          alert("Payment failed !!! ");
      },
        err => {
          alert("Currently unable to pay !!!");
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
  plusProductInCart(id: number, quantity: number, size: string){
    this.accountName = localStorage.getItem("accountName");
      this.userService.plusProductInCart(this.accountName, id, quantity, size)
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
  minusProductInCart(id: number, quantity: number, size:string){
    this.accountName = localStorage.getItem("accountName");
      this.userService.minusProductInCart(this.accountName, id, quantity, size)
      .pipe(first()).subscribe(res=>{
        if(res.success == "true"){
          this.clients.forEach(product => {
            if (product.product_id == res.data.product_id && product.quantity!= 1 ) {
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

  plusSizeInCart(id: number, quantity: number, size: string){
    if(+size > 41){
      return;
    }
    this.accountName = localStorage.getItem("accountName");
      this.userService.plusSizeInCart(this.accountName, id, quantity, size)
      .pipe(first()).subscribe(res=>{
        if(res.success == "true"){
          this.clients.forEach(product => {
            if (product.product_id == res.data.product_id && product.size!= 42 ) {
              product.size= +product.size + 1;
              return;
            }
          });
        }
      },
      err=>{
  
      }); 
  }
  minusSizeInCart(id: number, quantity: number, size:string){
    if(+size < 33){
      return;
    }
    this.accountName = localStorage.getItem("accountName");
      this.userService.minusSizeInCart(this.accountName, id, quantity, size)
      .pipe(first()).subscribe(res=>{
        if(res.success == "true"){
          this.clients.forEach(product => {
            if (product.product_id == res.data.product_id && product.size!= 32 ) {
              product.size= +product.size - 1;
              return;
            }
          });
        }
      },
      err=>{
  
      }); 
  }

}
