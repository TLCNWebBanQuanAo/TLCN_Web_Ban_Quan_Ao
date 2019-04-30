import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../../models/product';
import { UserServiceService } from '../_service/user-service/user-service.service';
import { first } from 'rxjs/operators';
import { Location } from '@angular/common';

@Component({
  selector: 'app-shop-product',
  templateUrl: './shop-product.component.html',
  styleUrls: ['./shop-product.component.css']
})
export class ShopProductComponent implements OnInit {
  accountName:string = "";
  userNameTemp:string = "";
  product: Product;
  id:number;
  quantity:number = 0;
  constructor(private route: ActivatedRoute, private userService: UserServiceService, private location: Location) { }

  ngOnInit() {
    this.accountName = localStorage.getItem("accountName");
    this.id = +this.route.snapshot.paramMap.get('id');
    this.quantity = +this.route.snapshot.paramMap.get('quantity');
    this.userService.getProduct(this.id).pipe(first())
    .subscribe(res=>{
      if(res.success == "true"){
        this.product = res.data;
        this.product.quantity = 1;
        if(this.quantity != 0)
          this.product.quantity = this.quantity;
      }
    },
    err=>{

    })
  }
  addProductInCart(){
    this.accountName = localStorage.getItem("accountName");
    this.id = +this.route.snapshot.paramMap.get('id');
    console.log(this.id);
    if(localStorage.getItem("accountName")!=""){
      this.userService.addProductInCart(this.accountName, this.id, this.product.quantity)
      .pipe(first()).subscribe(res=>{
        if(res.success == "true")
          alert("Cập nhật giỏ hàng !!!");
      },
      err=>{
  
      });
    }else
    alert("Mời bạn đăng nhập để thao tác!");
    
  }

  goBack(){
    this.location.back();
  }

}
