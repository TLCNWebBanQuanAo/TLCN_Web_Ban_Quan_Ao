import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ShopIndexComponent } from './shop-index/shop-index.component';
import { ShopProductComponent } from './shop-product/shop-product.component';
import { ShopCategoryComponent } from './shop-category/shop-category.component';
import { ShopCheckoutComponent } from './shop-checkout/shop-checkout.component';
import { ShopCartComponent } from './shop-cart/shop-cart.component';
import { ShopLoginComponent } from './shop-login/shop-login.component';
import { ShopRegisterComponent } from './shop-register/shop-register.component';
import { AdAddproductComponent } from './ad-addproduct/ad-addproduct.component';
import { AdListproductComponent } from './ad-listproduct/ad-listproduct.component';
import { AdEditproductComponent } from './ad-editproduct/ad-editproduct.component';
import { ShopProfileComponent } from './shop-profile/shop-profile.component';

import { GuestServiceService } from './_service/guest-service/guest-service.service';
import { UserServiceService } from './_service/user-service/user-service.service';
import { from } from 'rxjs';
import { ShopHeaderComponent } from './shop-header/shop-header.component';
import { ShopMenuComponent } from './shop-menu/shop-menu.component';
import { AdMenuComponent } from './ad-menu/ad-menu.component';
import { ShopFooterComponent } from './shop-footer/shop-footer.component';
import { ShopBillComponent } from './shop-bill/shop-bill.component';
import { AdAddtypeComponent } from './ad-addtype/ad-addtype.component';
import { AdListtypeComponent } from './ad-listtype/ad-listtype.component';
import { AdListuserComponent } from './ad-listuser/ad-listuser.component';

@NgModule({
  declarations: [
    AppComponent,
    ShopIndexComponent,
    ShopProductComponent,
    ShopCategoryComponent,
    ShopCheckoutComponent,
    ShopCartComponent,
    ShopLoginComponent,
    ShopRegisterComponent,
    AdAddproductComponent,
    AdListproductComponent,
    AdEditproductComponent,
    ShopProfileComponent,
    ShopHeaderComponent,
    ShopMenuComponent,
    AdMenuComponent,
    ShopFooterComponent,
    ShopBillComponent,
    AdAddtypeComponent,
    AdListtypeComponent,
    AdListuserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    GuestServiceService,
    UserServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
