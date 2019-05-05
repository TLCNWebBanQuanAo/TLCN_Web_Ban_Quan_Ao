import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { User } from '../../../models/user';
import { Observable } from'rxjs'
import { from } from 'rxjs';
import{ HttpClient, HttpHeaders } from '@angular/common/http'
import { Product } from 'src/models/product';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  user: User;
  product: Product;
  context = environment.base_user_url;

  constructor( private http: HttpClient ) { 
    
  }
  laythongtinnguoidung(accountName: String): Observable<any>{
    return this.http.get(`${this.context}api/v1/user/${accountName}`
    );
  }
  doiMatKhau(accountname: string, oldpassword: string, newpassword: string) : Observable<any>{
    return this.http.post(`${this.context}/api/v1/user/changepassword/${accountname}/${oldpassword}/${newpassword}`,"");
  }
  suathongtinnguoidung(user: User): Observable<any>{
    return this.http.post(`${this.context}api/v1/user/changepersonalinformation`,user);
  }
  changeAvatar(user:User):Observable<any>{
    return this.http.post(`${this.context}api/v1/user/changeavatar`, user);
  }
  getInvoicesByUser(accountName:string):Observable<any>{
    return this.http.get(`${this.context}api/v1/user/getbilllist/${accountName}`);
  }
  layavatar(accountName: String): Observable<any> {
    return this.http.get(`${this.context}api/v1/user/${accountName}`
    );
  }
  laythongtingiohang(accountName: String): Observable<any>{
    return this.http.get(`${this.context}api/v1/user/getproductincart/${accountName}`
    );
  }
  addProductInCart(accountName:string, product_id:Number, quantity:Number, size:string): Observable<any>{
    return this.http.post(`${this.context}api/v1/user/addproductincart/${accountName}/${product_id}/${quantity}/${size}`,"");
  }

  getProduct(productId:Number):Observable<any>{
    return this.http.get(`${this.context}api/v1/user/product/${productId}`);
  }
  getAllProductsPage(type:number ,keyword:string, page:number, size:number): Observable<any>{
    if(!keyword)
      keyword = "";
    return this.http.get(`${this.context}api/v1/user/products?keyword=${keyword}&page=${page}&size=${size}&id=${type}`);
  }
  getAllCategories():Observable<any>{
    return this.http.get(`${this.context}api/v1/user/types`);
  }
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
  plusProductInCart(accountName:string, product_id:Number, quantity:Number, size:string): Observable<any>{
    return this.http.post(`${this.context}api/v1/user/plusproductincart/${accountName}/${product_id}/${quantity}/${size}`,"");
  }
  minusProductInCart(accountName:string, product_id:Number, quantity:Number, size:string): Observable<any>{
    return this.http.post(`${this.context}api/v1/user/minusproductincart/${accountName}/${product_id}/${quantity}/${size}`,"");
  }
  plusSizeInCart(accountName:string, product_id:Number, quantity:Number, size:string): Observable<any>{
    return this.http.post(`${this.context}api/v1/user/plussizeincart/${accountName}/${product_id}/${quantity}/${size}`,"");
  }
  minusSizeInCart(accountName:string, product_id:Number, quantity:Number, size:string): Observable<any>{
    return this.http.post(`${this.context}api/v1/user/minussizeincart/${accountName}/${product_id}/${quantity}/${size}`,"");
  }
}
