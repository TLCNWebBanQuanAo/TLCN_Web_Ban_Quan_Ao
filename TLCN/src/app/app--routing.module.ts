import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';
import{RouterModule, Routes} from '@angular/router'
import{LoginComponent} from './login/login.component'
import{RigisterComponent} from './rigister/rigister.component'
import{HomepageComponent} from './homepage/homepage.component'
import{SingleComponent} from './single/single.component'
import{AllItemComponent} from './all-item/all-item.component'
import{CartComponent} from './cart/cart.component'


const router: Routes=[
  {path: 'login', component: LoginComponent},
  {path:'register',component:RigisterComponent},
  {path:'homepage',component:HomepageComponent},
  {path: 'single',component:SingleComponent},
  {path: 'allitem',component:AllItemComponent},
  {path: 'cart',component:CartComponent},
  {path: '', redirectTo:'/homepage',pathMatch: 'full'}
];

@NgModule({
  imports: [
    //CommonModule
    RouterModule.forRoot(router)
  ],
  //declarations: []
  exports:[RouterModule]
})
export class AppRoutingModule { }
