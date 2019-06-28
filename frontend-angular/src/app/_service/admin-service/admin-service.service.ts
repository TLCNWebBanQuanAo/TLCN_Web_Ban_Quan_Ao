import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../../models/user';
import { Type } from '../../../models/type';
import { Product } from '../../../models/product';
import { StatisticsDTO } from '../../../models/statisticsDTO';
import { catchError, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {
  
  context = environment.base_admin_url;

  constructor( private http: HttpClient ) { }

  GetListUser() : Observable<any> {
    return this.http.get(`${this.context}/api/v1/admin/user/users`);
  }

  GetListType() : Observable<any> {
    return this.http.get(`${this.context}/api/v1/admin/type/types`)
  }
  
  updateStatusUser(id) : Observable<any> {
    return this.http.post(`${this.context}/api/v1/admin/user/edituser`, id);
  }

  createType(type: Type) : Observable<any> {
    return this.http.post(`${this.context}/api/v1/admin/type/addtype`, type);
  }

  updateType(type: Type) : Observable<any> {
    return this.http.post(`${this.context}/api/v1/admin/type/edittype`, type);
  }

  createProduct(product: Product, id) : Observable<any> {
    return this.http.post(`${this.context}/api/v1/admin/product/addproduct/${id}`, product);
  }

  editProduct(product: Product) : Observable<any> {
    return this.http.post(`${this.context}/api/v1/admin/product/editproduct`, product,{observe: 'body'});
  }

  GetListProduct() : Observable<any> {
    return this.http.get(`${this.context}/api/v1/admin/product/products`)
  }

  updateStatusProduct(id) : Observable<any> {
    return this.http.post(`${this.context}/api/v1/admin/product/editStatusproduct`, id);
  }
  private url = "http://localhost:8083//api/v1/admin/product/statictics/figures";
  getProductStatistics(dateStart:string, dateEnd:string) : Observable<any>{
    let statisticsDTO:StatisticsDTO = JSON.parse('{ "dateStart": "' + dateStart + '",' + '"dateEnd": "' + dateEnd + '"}'); 
    return this.http.post(this.url, statisticsDTO);
  }

  getProduct(productId:Number):Observable<any>{
    return this.http.get(`${this.context}/api/v1/admin/product/products/${productId}`);
  }

  getAllOrder():Observable<any>{
    return this.http.get(`${this.context}/api/v1/admin/user/order`);
  }

  getBillDetailList(bill_id: number): Observable<any>{
    return this.http.get(`${this.context}/api/v1/admin/user/detailBill/${bill_id}`);
  }

  setStatus(id: number, userUpdate: String): Observable<any>{
    return this.http.get(`${this.context}/api/v1/admin/user/order/update/${id}/${userUpdate}`);
  }
}
