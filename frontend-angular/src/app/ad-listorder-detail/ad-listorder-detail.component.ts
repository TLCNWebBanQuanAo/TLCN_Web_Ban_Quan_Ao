import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';
import { first } from 'rxjs/operators';
import { User } from '../../models/user';
import { AdminServiceService } from '../_service/admin-service/admin-service.service';
import * as moment from 'moment';
import { ActivatedRoute } from '@angular/router'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Product } from '../../models/product';
import { from } from 'rxjs';
import { isNumber } from 'util';


@Component({
  selector: 'app-ad-listorder-detail',
  templateUrl: './ad-listorder-detail.component.html',
  styleUrls: ['./ad-listorder-detail.component.css']
})
export class AdListorderDetailComponent implements OnInit {
  clients: any[];
  error: string;
  id: number;
  tong: number = 0;

  constructor(private http: HttpClient, private router: ActivatedRoute, private adminService: AdminServiceService, private fb: FormBuilder) { }

  ngOnInit() {
    this.id = +this.router.snapshot.paramMap.get('id');
    this.adminService.getBillDetailList(this.id).pipe(first())
      .subscribe(res => {
        this.clients = res.data;
        for (let i = 0; i < this.clients.length; i++) {
          this.tong += this.clients[i].price * this.clients[i].quantity;
        }
      });
  }
}
