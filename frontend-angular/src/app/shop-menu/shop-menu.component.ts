import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/user';

@Component({
  selector: 'app-shop-menu',
  templateUrl: './shop-menu.component.html',
  styleUrls: ['./shop-menu.component.css']
})
export class ShopMenuComponent implements OnInit {
  isAdmin: boolean = false;
  role: string;
  constructor() {
   }

  ngOnInit() {
    this.role = localStorage.getItem("role");
    if(this.role == "1")
      this.isAdmin = true;
  }
}
