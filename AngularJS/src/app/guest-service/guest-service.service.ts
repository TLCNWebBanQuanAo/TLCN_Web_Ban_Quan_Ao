import { Injectable } from '@angular/core';
import{environment} from '../../environments/environment';
import{User} from '../../models/user'
import{Observable} from'rxjs'
import { from } from 'rxjs';
import{HttpClient, HttpHeaders} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class GuestServiceService {
  user: User
  context = environment.base_guest_url;

  constructor(private http: HttpClient) { }
  login(user: User): Observable<any>{
    return this.http.post(`${this.context}api/v1/guest/login/${user.accountName}/${user.password}`
    ,"");
  }
  register(user: User): Observable<any>{
    return this.http.post(`${this.context}api/v1/guest/register`,user,{observe:`response`});
  }
}
