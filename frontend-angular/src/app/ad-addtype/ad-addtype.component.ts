import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Type } from '../../models/type';
import { AdminServiceService } from '../_service/admin-service/admin-service.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-ad-addtype',
  templateUrl: './ad-addtype.component.html',
  styleUrls: ['./ad-addtype.component.css']
})
export class AdAddtypeComponent implements OnInit {
  type: Type;

  constructor(private http: HttpClient, private chRef: ChangeDetectorRef, private router: Router, private adminservice: AdminServiceService) {
    this.type = new Type();
   }

  ngOnInit() {
    this.type.name = "";
  }

  createType() {
    if (this.type.name != "") {
      this.adminservice.createType(this.type).pipe(first()).subscribe(res => {
        this.type.name = "";
        alert("Add successful product type.");
      },
        err => {
          alert("Add product types failed!!!");
        })
    } else {
      alert("Product type has not been entered!!!");
    }

  }

  Cancel() {
    window.location.href = "/listtype";
  }

}
