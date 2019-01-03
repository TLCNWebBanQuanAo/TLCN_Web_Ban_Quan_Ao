import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router'
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
role: number=0;
count:number=0;
  constructor(private router: Router) { }

  ngOnInit() {
    this.count= +localStorage.getItem("count");
    this.role= +localStorage.getItem("role");
  }
  Logout() {
    localStorage.setItem("accountName","");
    localStorage.setItem("role","");
    localStorage.setItem("count", "1");
    this.router.navigate(["/login"]);
  }
}
