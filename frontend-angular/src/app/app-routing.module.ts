import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShopIndexComponent } from './shop-index/shop-index.component';
import { ShopProductComponent } from './shop-product/shop-product.component';
import { ShopCategoryComponent } from './shop-category/shop-category.component';
import { ShopCheckoutComponent } from './shop-checkout/shop-checkout.component';
import { ShopCartComponent } from './shop-cart/shop-cart.component';
import { ShopLoginComponent } from './shop-login/shop-login.component';
import { ShopRegisterComponent } from './shop-register/shop-register.component';

const routes: Routes = [
  { path: '', component: ShopIndexComponent },
  { path: 'product', component: ShopProductComponent },
  { path: 'category', component: ShopCategoryComponent },
  { path: 'checkout', component: ShopCheckoutComponent},
  { path: 'cart', component: ShopCartComponent },
  { path: 'login', component: ShopLoginComponent},
  { path: 'register', component: ShopRegisterComponent}
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
