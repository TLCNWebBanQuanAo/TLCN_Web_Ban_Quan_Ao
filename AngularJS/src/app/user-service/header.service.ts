import { Injectable } from '@angular/core';
import{environment} from '../../environments/environment';
import{User} from '../../models/user'
import{Observable} from'rxjs'
import { from } from 'rxjs';
import{HttpClient, HttpHeaders} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class HeaderService {
  user: User
  context = environment.base_user_url;

  constructor(private http: HttpClient) {
    
   }
   layavatar(accountName: String): Observable<any>{
    return this.http.get(`${this.context}api/v1/user/${accountName}`
    );
  }
}
