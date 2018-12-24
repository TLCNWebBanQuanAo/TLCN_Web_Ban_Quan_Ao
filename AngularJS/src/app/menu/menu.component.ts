import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router'
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  Logout() {
    localStorage.setItem("accountName","");
    localStorage.setItem("role","");
    this.router.navigate(["/login"]);
  }
}
