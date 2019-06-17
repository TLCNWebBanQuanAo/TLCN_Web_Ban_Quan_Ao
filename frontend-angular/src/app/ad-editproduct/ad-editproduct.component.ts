import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../../models/product';
import { AdminServiceService } from '../_service/admin-service/admin-service.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { Type } from '../../models/type';
import { UserServiceService } from '../_service/user-service/user-service.service';

@Component({
  selector: 'app-ad-editproduct',
  templateUrl: './ad-editproduct.component.html',
  styleUrls: ['./ad-editproduct.component.css']
})
export class AdEditproductComponent implements OnInit {
  product: Product;
  types: Type[];
  typeid: number;
  selectedOption: number; 
  error: string;
  formImage: FormGroup;
  image: string = "";
  imageUploaded: string = "";
  id: Number;
  constructor(private route: ActivatedRoute, private adminservice: AdminServiceService,private userservice: UserServiceService) { }

  ngOnInit() {
    
    this.route.params.subscribe(param => {
      this.id = param.id;
      console.log(this.id);

      this.adminservice.getProduct(this.id).pipe(first())
        .subscribe(res=>{
          this.product= res;
        },
        err=>{

        })
    })
    
  }
  editproduct() {
    this.adminservice.editProduct(this.product).pipe(first()).subscribe(res => {
      if (res.success = "true") {
        alert("Update your product successfully !!!");
      }
      else {
        alert("Update your product failed !!!");
      }
    },
      err => {
        alert("Can't update your product !!!");
      })
  }

}
