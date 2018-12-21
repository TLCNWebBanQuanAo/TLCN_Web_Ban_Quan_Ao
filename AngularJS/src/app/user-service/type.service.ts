import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Type } from '../../models/type';
import { Observable } from 'rxjs';
import { of } from 'rxjs';

/*service*/
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {catchError, tap} from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class TypeService {

  context = environment.base_user_url;
  constructor(private http: HttpClient) { }
  getAllCategories():Observable<any>{
    return this.http.get(`${this.context}api/v1/user/types`);
  }
}
