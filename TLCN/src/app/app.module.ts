import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { RigisterComponent } from './rigister/rigister.component';
import { AppRoutingModule } from './app--routing.module';
import { HomepageComponent } from './homepage/homepage.component';
import { SingleComponent } from './single/single.component';
import { AllItemComponent } from './all-item/all-item.component';
import { CartComponent } from './cart/cart.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    MenuComponent,
    RigisterComponent,
    HomepageComponent,
    SingleComponent,
    AllItemComponent,
    CartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
