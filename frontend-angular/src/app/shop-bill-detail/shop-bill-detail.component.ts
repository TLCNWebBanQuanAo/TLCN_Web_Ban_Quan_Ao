import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';
import { first } from 'rxjs/operators';
import { User } from '../../models/user';
import { UserServiceService } from '../_service/user-service/user-service.service';
import * as moment from 'moment';
import { ActivatedRoute } from '@angular/router'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Product } from '../../models/product';
import { from } from 'rxjs';
import { isNumber } from 'util';

@Component({
  selector: 'app-shop-bill-detail',
  templateUrl: './shop-bill-detail.component.html',
  styleUrls: ['./shop-bill-detail.component.css']
})
export class ShopBillDetailComponent implements OnInit {
  clients: any[];
  error: string;
  id: number;
  tong: number = 0;

  constructor(private http: HttpClient, private router: ActivatedRoute, private userService: UserServiceService, private fb: FormBuilder) { }

  ngOnInit() {
    this.id = +this.router.snapshot.paramMap.get('id');
    this.userService.getBillDetailList(this.id).pipe(first())
      .subscribe(res => {
        this.clients = res.data;
        for (let i = 0; i < this.clients.length; i++) {
          this.tong += this.clients[i].price * this.clients[i].quantity;
        }
      });
  }
}
