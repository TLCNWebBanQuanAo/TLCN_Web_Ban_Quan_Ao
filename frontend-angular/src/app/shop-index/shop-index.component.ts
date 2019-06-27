import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../_service/user-service/user-service.service';
import { Observable } from 'rxjs';
import { Product } from '../../models/product';
import { ActivatedRoute, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import * as $ from 'jquery';
import { first } from 'rxjs/operators';
import { Location } from '@angular/common';
import { Type } from '../../models/type';

@Component({
  selector: 'app-shop-index',
  templateUrl: './shop-index.component.html',
  styleUrls: ['./shop-index.component.css']
})
export class ShopIndexComponent implements OnInit {
  products: Observable<Product[]>;
  keyword: string = "";
  page: number;
  type: Type[];
  pageNumber: number = 0;
  pageArray: Array<number> = [];
  size: number;
  current: number;
  error: string;
  isEmpty: boolean;
  selectedExcel: any;
  accountName: string;
  id: number;
  typeid: number = 0;
  isAdmin: boolean = false;
  role: string;

  constructor(private router: Router, private userService: UserServiceService, private route: ActivatedRoute) {
    this.page = 0;
    this.size = 8;
    this.current = 0;
    this.isEmpty = false;
  }

  ngOnInit() {
    this.onInit();
    this.role = localStorage.getItem("role");
    if(this.role == "1")
      this.isAdmin = true;
  }
  async onInit() {
    this.getAllCategories();

    // Get Products on Page
    this.getAllProductOnPage(this.typeid, this.keyword, this.page, this.size);
  }
  getAllProductOnPage(type: number, keyword: string, page: number, size: number) {
    this.userService.getAllProductsPage(type, keyword, page, size)
      .pipe(first()).subscribe(res => {
        if (res.success == "true") {
          this.products = res.data;
          this.pageNumber = res.pagenumber;
          for (let index = 0; index < this.pageNumber; index++) {
            this.pageArray.push(index);
          }
          this.current = page;
        }
      },
        err => {
          alert("Can't get product list !!!");
        });
  }
  getAllCategories() {
    this.userService.getAllCategories().pipe(first())
      .subscribe(res => {
        if (res.success == "true") {
          this.type = res.data;
          const typeAll: Type = new Type;
          typeAll.id = 0;
          typeAll.name = "All";
          this.type.unshift(typeAll);
          console.log(this.type);
        }
      },
        err => {
          localStorage.clear();
          this.router.navigateByUrl('/homepage');
        });
  }
  onChangeProductType() {
    this.pageArray = [];
    this.getAllProductOnPage(this.typeid, this.keyword, 0, this.size);
  }

  onFilter() {
    this.pageArray = [];
    this.getAllProductOnPage(this.typeid, this.keyword, 0, this.size);
  }

  onGotoPage(page: number) {
    this.pageArray = [];
    this.getAllProductOnPage(this.typeid, this.keyword, page, this.size);
  }

  onPrePage() {
    this.current--;
    this.pageArray = [];
    this.getAllProductOnPage(this.typeid, this.keyword, this.current, this.size);
  }

  onNextPage() {
    this.pageArray = [];
    this.current++;
    this.getAllProductOnPage(this.typeid, this.keyword, this.current, this.size);
  }
  addProductInCart(id: number) {

    if (localStorage.getItem("accountName") != "") {
      this.accountName = localStorage.getItem("accountName");
      this.userService.addProductInCart(this.accountName, id, 1, "32")
        .pipe(first()).subscribe(res => {
          if (res.success == "true")
            alert("Update cart.");
        },
          err => {

          });
    }
    else
      alert("Please login to operate.");

  }
  addProductInWishList(id: number, price: number) {

    if (localStorage.getItem("accountName") != "") {
      this.accountName = localStorage.getItem("accountName");
      this.userService.addProductInWishList(this.accountName, id, price*0.9)
        .pipe(first()).subscribe(res => {
          if (res.success == "true")
            alert("Update wish list.");
        },
          err => {

          });
    }
    else
      alert("Please login to operate.");

  }
}