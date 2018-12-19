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
}
