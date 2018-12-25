import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../../models/product';
import { AdminServiceService } from '../admin-service/admin-service.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { Type } from '../../models/type';

@Component({
  selector: 'app-ad-addproduct',
  templateUrl: './ad-addproduct.component.html',
  styleUrls: ['./ad-addproduct.component.css']
})
export class AdAddproductComponent implements OnInit {
  product: Product;
  types: Type[];
  typeid: number;
  selectedOption: number; 
  error: string;
  formImage: FormGroup;
  image: string = "";
  imageUploaded: string = "";

  constructor(private http: HttpClient, private chRef: ChangeDetectorRef, private fb: FormBuilder, private router: Router, private adminservice: AdminServiceService) {
    this.product = new Product();
    this.formImage = this.fb.group({
      name: ['', Validators.required],
      avatar: null
    });
  }

  ngOnInit() {
    this.getAllType();
  }

  changeSelected(){
    alert(this.selectedOption)
  }

  getAllType() {
    this.adminservice.GetListType().subscribe(res => {
      this.types = res;
    }, err => {
      console.log(err.message)
    });
  }

  
  onChangedImage(event){
    let reader = new FileReader();
    if(event.target.files && event.target.files.length > 0) {
      let file = event.target.files[0];
      reader.readAsDataURL(file);
       reader.onload = () => {
        this.image = "data:" + file.type + ";base64," + reader.result.split(',')[1];
        this.formImage.get('avatar').setValue({
          filename: file.name,
          filetype: file.type,
          value: "data:" + file.type + ";base64," + reader.result.split(',')[1]
        })
      };
    }
  }
  
  onSaveImage(){
    this.imageUploaded = this.formImage.get('avatar').value.value;
    this.product.images = this.imageUploaded;
    this.product.status = 1;
    this.typeid = this.selectedOption;


    this.adminservice.createProduct(this.product, this.typeid).pipe(first())
    .subscribe(res=>{
        alert("Thêm sản phẩm thành công !!!");
    },
    err=>{
        alert("Thêm sản phẩm không thành công !!!");
    });
  }

}
