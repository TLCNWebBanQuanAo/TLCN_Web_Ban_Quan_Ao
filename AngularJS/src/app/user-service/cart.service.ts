import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Product } from '../../models/product';
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
}
