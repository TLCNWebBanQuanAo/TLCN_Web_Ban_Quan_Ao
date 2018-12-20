import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {
  
  context = environment.base_admin_url;
  constructor(private http: HttpClient) { }

  GetListUser() : Observable<any> {
    return this.http.get(`${this.context}/api/v1/admin/user/users`);
  }

  GetListType() : Observable<any> {
    return this.http.get(`${this.context}/api/v1/admin/type/types`)
  }
}
