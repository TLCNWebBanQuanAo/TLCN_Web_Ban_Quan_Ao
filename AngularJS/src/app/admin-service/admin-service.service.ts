import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/models/user';
import { Type } from '../../models/type';


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
  
  updateStatusUser(id) : Observable<any> {
    return this.http.post(`${this.context}/api/v1/admin/user/edituser`, id);
  }

  createType(type: Type) : Observable<any> {
    return this.http.post(`${this.context}/api/v1/admin/type/addtype`, type);
  }

  updateType(type: Type) : Observable<any> {
    return this.http.post(`${this.context}/api/v1/admin/type/edittype`, type);
  }
}
