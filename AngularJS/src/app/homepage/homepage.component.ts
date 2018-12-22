import { Component, OnInit } from '@angular/core';
import { UserproductService } from '../user-service/userproduct.service';
import { Observable } from 'rxjs';
import { Product } from '../../models/product';
import { ActivatedRoute, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import * as $ from 'jquery';
import { first } from 'rxjs/operators';
import { Location } from '@angular/common';
import { TypeService } from '../user-service/type.service';
import { Type } from '../../models/type';


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  products: Observable<Product[]>;
  keyword: string="";
  page: number;
  type: Type[];
  pageNumber: number;
  pageArray: Array<number> = [];
  size: number;
  current: number;
  error: string;
  isEmpty: boolean;
  selectedExcel: any;
  accountName: string;
  id: number;
  typeid: number= 0;

  constructor(private router: Router, private productService: UserproductService, private route: ActivatedRoute, private typeService: TypeService) { 
    this.page = 0;
    this.size = 8;
    this.current = 0;
    this.isEmpty = false;
  }

  ngOnInit() {
    this.onInit();
  }
  async onInit(){
    this.getAllCategories();

    // Get Products on Page
    this.getAllProductOnPage(this.typeid ,this.keyword, this.page, this.size);
  }
  getAllProductOnPage(type:number ,keyword: string, page: number, size: number){
    this.productService.getAllProductsPage(type ,keyword, page, size)
    .pipe(first()).subscribe(res=>{
      if(res.success == "true"){
        this.products = res.data;
        this.pageNumber = res.pageNumber;
        for (let index = 0; index < this.pageNumber; index++) {
          this.pageArray.push(index);
        }
        this.current = page;
      }
    },
    err=>{
      alert("Không lấy được danh sách sản phẩm ???");
    });
  }
  getAllCategories(){
    this.typeService.getAllCategories().pipe(first())
    .subscribe(res =>{
      if(res.success == "true"){
        this.type = res.data;
        const typeAll:Type = new Type;
        typeAll.id = 0;
        typeAll.name = "Tất cả";
        this.type.unshift(typeAll);
        console.log(this.type);
      }
    },
    err=>{
      localStorage.clear();
      this.router.navigateByUrl('/homepage');
    });
  }
  onChangeProductType(){
    this.pageArray = [];
    this.getAllProductOnPage(this.typeid,this.keyword, 0, this.size);
  }

  onFilter(){
    this.pageArray = [];
    this.getAllProductOnPage(this.typeid,this.keyword, 0, this.size);
  }

  onGotoPage(page: number) {
    this.pageArray = [];
    this.getAllProductOnPage(this.typeid,this.keyword, page, this.size);
  }

  onPrePage() {
    this.current--;
    this.pageArray = [];
    this.getAllProductOnPage(this.typeid,this.keyword, this.current, this.size);
  }

  onNextPage() {
    this.pageArray = [];
    this.current++;
    this.getAllProductOnPage(this.typeid,this.keyword, this.current, this.size);
  }
  addProductInCart(id: number){
    this.accountName = localStorage.getItem("accountName");
    this.productService.addProductInCart(this.accountName, id, 1)
    .pipe(first()).subscribe(res=>{
      if(res.success == "true")
        alert("Cập nhật giỏ hàng !!!");
    },
    err=>{

    });
  }
}
