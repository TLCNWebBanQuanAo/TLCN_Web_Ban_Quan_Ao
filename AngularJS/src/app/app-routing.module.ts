import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';
import{RouterModule, Routes} from '@angular/router'
import{LoginComponent} from './login/login.component'
import{RegisterComponent} from './register/register.component'
import{HomepageComponent} from './homepage/homepage.component'
import{SingleComponent} from './single/single.component'
import{AllItemComponent} from './all-item/all-item.component'
import{CartComponent} from './cart/cart.component'
import{AdtypeComponent} from './adtype/adtype.component'
import{AdsaleComponent} from './adsale/adsale.component'
import{AdproductComponent} from './adproduct/adproduct.component'
import{AduserComponent} from './aduser/aduser.component'
import { AdAddproductComponent } from './ad-addproduct/ad-addproduct.component';
import { AdAddsaleComponent } from './ad-addsale/ad-addsale.component';
import { AdAddtypeComponent } from './ad-addtype/ad-addtype.component';
import { AdEditproductComponent } from './ad-editproduct/ad-editproduct.component';
import { AdEdittypeComponent } from './ad-edittype/ad-edittype.component';
import { AdEditsaleComponent } from './ad-editsale/ad-editsale.component';
import { AdEdituserComponent } from './ad-edituser/ad-edituser.component';
import { UserprofileComponent } from './userprofile/userprofile.component';
import { AdminFramesComponent } from './admin-frames/admin-frames.component';
import { fromEventPattern } from 'rxjs';

const router: Routes=[
  {path: 'login', component: LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'homepage',component:HomepageComponent},
  {path: 'single',component:SingleComponent},
  {path: 'allitem',component:AllItemComponent},
  {path: 'cart',component:CartComponent},
  {path: 'adtype',component:AdtypeComponent},
  {path: 'adsale',component:AdsaleComponent},
  {path: 'aduser',component:AduserComponent},
  {path: 'adproduct',component:AdproductComponent},
  {path: 'ad-addsale',component:AdAddsaleComponent},
  {path: 'ad-addproduct',component:AdAddproductComponent},
  {path: 'ad-addtype',component:AdAddtypeComponent},
  {path: 'ad-edittype',component:AdEdittypeComponent},
  {path: 'ad-editsale',component:AdEditsaleComponent},
  {path: 'ad-editproduct',component:AdEditproductComponent},
  {path: 'ad-edituser',component:AdEdituserComponent},
  {path: 'userprofile', component:UserprofileComponent},
  {path: 'frames', component:AdminFramesComponent},
  {path: '', redirectTo:'/homepage',pathMatch: 'full'}
];
@NgModule({
  imports: [
    RouterModule.forRoot(router)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
