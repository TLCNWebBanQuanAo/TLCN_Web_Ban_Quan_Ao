import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Product } from '../../models/product';
import { User } from '../../models/user';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {catchError, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  context = environment.base_user_url;
  constructor(private http: HttpClient) { }

  deleteAllProductInCart(accountName:string):Observable<any>{
    return this.http.delete(`${this.context}/api/v1/user/deleteallproductincart/${accountName}`);
  }

  deleteProductInCart(accountName:string, productId:number): Observable<any>{
    return this.http.delete(`${this.context}/api/v1/user/deleteproductincart/${accountName}/${productId}`);
  }

  getProductInCart(accountName: string): Observable<any>{
    return this.http.get(`${this.context}/api/v1/user/getproductincart/${accountName}`);
  }
  thanhToan(accountName:string, diaChiGiaoHang:string, tongTien:number, status: number):Observable<any>{
    let user:User = JSON.parse('{ "accountName": "' + accountName+ '",' + '"address": "' +diaChiGiaoHang+ '",'  + '"status": "'+status+ '"}');
    return this.http.post(`${this.context}/api/v1/user/thanhtoan/${tongTien}`, user);
  }
  plusProductInCart(accountName:string, product_id:Number, quantity:Number): Observable<any>{
    return this.http.post(`${this.context}api/v1/user/plusproductincart/${accountName}/${product_id}/${quantity}`,"");
  }
  minusProductInCart(accountName:string, product_id:Number, quantity:Number): Observable<any>{
    return this.http.post(`${this.context}api/v1/user/minusproductincart/${accountName}/${product_id}/${quantity}`,"");
  }
}
