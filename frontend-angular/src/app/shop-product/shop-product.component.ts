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
  quantity: number = 1;
  dealPrice: number;
  size: string;
  constructor(private route: ActivatedRoute, private userService: UserServiceService, private location: Location) { }

  ngOnInit() {
    this.accountName = localStorage.getItem("accountName");
    this.id = +this.route.snapshot.paramMap.get('id');
    this.userService.getProduct(this.id).pipe(first())
    .subscribe(res=>{
      if(res.success == "true"){
        this.product = res.data;
      }
    },
    err=>{

    })
  }
  addProductInCart(){
    this.accountName = localStorage.getItem("accountName");
    this.product.size = this.size;
    this.id = +this.route.snapshot.paramMap.get('id');
    if(this.product.quantity < this.quantity){
      alert("Sorry, the current item is not in sufficient quantity");
    }
    else{
      if(localStorage.getItem("accountName")!=""){
        this.userService.addProductInCart(this.accountName, this.id, this.quantity, this.product.size, this.product.price)
        .pipe(first()).subscribe(res=>{
          if(res.success == "true")
            alert("Update shopping cart.");
        },
        err=>{
    
        });
      }else
      alert("Please login to operate.");
    }
    
    
  }

  addProductInWishlist(){
    this.accountName = localStorage.getItem("accountName");
    this.id = +this.route.snapshot.paramMap.get('id');
    if(localStorage.getItem("accountName")!=""){
      if(this.dealPrice==null)
      {
        alert("please choose your dealPrice.");
      }
      else
      if(this.dealPrice >= this.product.price){
      alert("CurrentPrice can't be less than DealPrice!!!");
      }
      else
      {
        this.userService.addProductInWishList(this.accountName, this.id, this.dealPrice)
        .pipe(first()).subscribe(res=>{
          if(res.success == "true")
            alert("Update wishlist.");
        },
        err=>{
    
        });
      }
      
    }else
    alert("Please login to operate.");
    
  }

  goBack(){
    this.location.back();
  }

}
