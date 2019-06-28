import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShopIndexComponent } from './shop-index/shop-index.component';
import { ShopProductComponent } from './shop-product/shop-product.component';
import { ShopCheckoutComponent } from './shop-checkout/shop-checkout.component';
import { ShopCartComponent } from './shop-cart/shop-cart.component';
import { ShopLoginComponent } from './shop-login/shop-login.component';
import { ShopRegisterComponent } from './shop-register/shop-register.component';
import { AdAddproductComponent } from './ad-addproduct/ad-addproduct.component';
import { AdListproductComponent } from './ad-listproduct/ad-listproduct.component';
import { AdListtypeComponent } from './ad-listtype/ad-listtype.component';
import { AdListuserComponent } from './ad-listuser/ad-listuser.component';
import { AdAddtypeComponent } from './ad-addtype/ad-addtype.component';
import { AdEditproductComponent } from './ad-editproduct/ad-editproduct.component';
import { ShopProfileComponent } from './shop-profile/shop-profile.component';
import { ShopBillComponent } from './shop-bill/shop-bill.component';
import {ShopWishlistComponent} from './shop-wishlist/shop-wishlist.component';
import {StatisticsComponent} from './statistics/statistics.component';
import { ShopBillDetailComponent } from './shop-bill-detail/shop-bill-detail.component';
import { AdListorderComponent } from './ad-listorder/ad-listorder.component';
import { AdListorderDetailComponent } from './ad-listorder-detail/ad-listorder-detail.component'

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
  { path: 'editproduct/:id', component: AdEditproductComponent },
  { path: 'profile', component: ShopProfileComponent },
  { path: 'listuser', component: AdListuserComponent },
  { path: 'bill', component: ShopBillComponent },
  { path: 'wishlist', component: ShopWishlistComponent},
  { path: 'statistic', component: StatisticsComponent},
  { path: 'order', component: AdListorderComponent},
  { path: 'billdetail/:id', component: ShopBillDetailComponent},
  { path: 'orderdetail/:id', component: AdListorderDetailComponent}
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
