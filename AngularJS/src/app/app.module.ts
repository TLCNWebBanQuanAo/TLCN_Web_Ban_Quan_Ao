import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { AllItemComponent } from './all-item/all-item.component';
import { CartComponent } from './cart/cart.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { RegisterComponent } from './register/register.component';
import { SingleComponent } from './single/single.component';
import { AdtypeComponent } from './adtype/adtype.component';
import { AdAddtypeComponent } from './ad-addtype/ad-addtype.component';
import { AdEditsaleComponent } from './ad-editsale/ad-editsale.component';
import { AdAddsaleComponent } from './ad-addsale/ad-addsale.component';
import { AdsaleComponent } from './adsale/adsale.component';
import { AdproductComponent } from './adproduct/adproduct.component';
import { AdAddproductComponent } from './ad-addproduct/ad-addproduct.component';
import { AdEditproductComponent } from './ad-editproduct/ad-editproduct.component';
import { AduserComponent } from './aduser/aduser.component';
import { MemuAdminComponent } from './memu-admin/memu-admin.component';
import { AdminMenuComponent } from './admin-menu/admin-menu.component';
import { GuestServiceService } from './guest-service/guest-service.service';
import { UserServiceService } from './user-service/user-service.service';
import{HeaderService} from './user-service/header.service'
import{TypeService} from './user-service/type.service'
import{UserproductService} from './user-service/userproduct.service'
import{HttpClientModule} from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { from } from 'rxjs';
import { UserprofileComponent } from './userprofile/userprofile.component';
import { AdminFramesComponent } from './admin-frames/admin-frames.component';
import { BillComponent } from './bill/bill.component';

@NgModule({
  declarations: [
    AppComponent,
    AllItemComponent,
    CartComponent,
    FooterComponent,
    HeaderComponent,
    HomepageComponent,
    LoginComponent,
    MenuComponent,
    RegisterComponent,
    SingleComponent,
    AdtypeComponent,
    AdAddtypeComponent,
    AdEditsaleComponent,
    AdAddsaleComponent,
    AdsaleComponent,
    AdproductComponent,
    AdAddproductComponent,
    AdEditproductComponent,
    AduserComponent,
    MemuAdminComponent,
    AdminMenuComponent,
    UserprofileComponent,
    AdminFramesComponent,
    BillComponent
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
    UserServiceService,
    UserproductService,
    HeaderService,
    TypeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
