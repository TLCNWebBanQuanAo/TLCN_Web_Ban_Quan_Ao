import { Injectable } from '@angular/core';
import{environment} from '../../environments/environment';
import{User} from '../../models/user'
import{Observable} from'rxjs'
import { from } from 'rxjs';
import{HttpClient, HttpHeaders} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  user: User
  context = environment.base_user_url;

  constructor(private http: HttpClient) { }
  laythongtinnguoidung(accountName: String): Observable<any>{
    return this.http.get(`${this.context}api/v1/user/${accountName}`
    );
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
}

