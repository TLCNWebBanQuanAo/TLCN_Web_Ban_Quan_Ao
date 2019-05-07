import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShopIndexComponent } from './shop-index/shop-index.component';
import { ShopProductComponent } from './shop-product/shop-product.component';
import { ShopCategoryComponent } from './shop-category/shop-category.component';
import { ShopCheckoutComponent } from './shop-checkout/shop-checkout.component';
import { ShopCartComponent } from './shop-cart/shop-cart.component';
import { ShopLoginComponent } from './shop-login/shop-login.component';
import { ShopRegisterComponent } from './shop-register/shop-register.component';
import { AdAddproductComponent } from './ad-addproduct/ad-addproduct.component';
import { AdListproductComponent } from './ad-listproduct/ad-listproduct.component';
import { AdAddtypeComponent } from './ad-addtype/ad-addtype.component';
import { AdListtypeComponent } from './ad-listtype/ad-listtype.component';
import { AdEditproductComponent } from './ad-editproduct/ad-editproduct.component';
import { AdListuserComponent } from './ad-listuser/ad-listuser.component';
import { ShopProfileComponent } from './shop-profile/shop-profile.component';
import { ShopBillComponent } from './shop-bill/shop-bill.component';
import { fromEventPattern, from } from 'rxjs';

const routes: Routes = [
  { path: '', component: ShopIndexComponent },
  { path: 'product/:id/:quantity', component: ShopProductComponent },
  { path: 'checkout', component: ShopCheckoutComponent},
  { path: 'cart', component: ShopCartComponent },
  { path: 'login', component: ShopLoginComponent },
  { path: 'register', component: ShopRegisterComponent },
  { path: 'addproduct', component: AdAddproductComponent },
  { path: 'listproduct', component: AdListproductComponent },
  { path: 'listtype', component: AdListtypeComponent },
  { path: 'addtype', component: AdAddtypeComponent },
  { path: 'editproduct', component: AdEditproductComponent },
  { path: 'profile', component: ShopProfileComponent },
  { path: 'listuser', component: AdListuserComponent },
  { path: 'bill', component: ShopBillComponent }
];

@NgModule({
  imports: [
    // CommonModule
    RouterModule.forRoot(routes)
  ],
  // declarations: []
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
