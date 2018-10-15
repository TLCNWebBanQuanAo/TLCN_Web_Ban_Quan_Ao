import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';
import{RouterModule, Routes} from '@angular/router'
import{LoginComponent} from './login/login.component'
import{RigisterComponent} from './rigister/rigister.component'

const router: Routes=[
  {path: 'login', component: LoginComponent},
  {path:'register',component:RigisterComponent},
  {path: '', redirectTo:'/login',pathMatch: 'full'}
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
