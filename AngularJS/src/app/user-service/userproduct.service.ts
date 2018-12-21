import { Injectable } from '@angular/core';
import{environment} from '../../environments/environment';
import{Product} from '../../models/product'
import{Observable} from'rxjs'
import { from } from 'rxjs';
import{HttpClient, HttpHeaders} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class UserproductService {
  product: Product
  context = environment.base_user_url;
  constructor(private http: HttpClient) { }
  laythongtingiohang(accountName: String): Observable<any>{
    return this.http.get(`${this.context}api/v1/user/getproductincart/${accountName}`
    );
  }
  addProductInCart(accountName:string, product_id:Number, quantity:Number): Observable<any>{
    return this.http.post(`${this.context}api/v1/user/addproductincart/${accountName}/${product_id}/${quantity}`,"");
  }

  getProduct(productId:Number):Observable<any>{
    return this.http.get(`${this.context}api/v1/user/product/${productId}`);
  }
  getAllProductsPage(type:number ,keyword:string, page:number, size:number): Observable<any>{
    if(!keyword)
      keyword = "";
    return this.http.get(`${this.context}api/v1/user/products?keyword=${keyword}&page=${page}&size=${size}&id=${type}`);
  }
}
