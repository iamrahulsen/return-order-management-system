import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import { OrderFormComponent } from './components/order-form/order-form.component';
import { ConfirmationComponent } from './components/confirmation/confirmation.component';
import { OrderStatusComponent } from './components/order-status/order-status.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { PaymentComponent } from './components/payment/payment.component';
import { TokenInterceptorService } from './Service/token-interceptor.service';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { IndexComponent } from './components/index/index.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    OrderFormComponent,
    ConfirmationComponent,
    OrderStatusComponent,
    PaymentComponent,
    NavbarComponent,
    PageNotFoundComponent,
    IndexComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: TokenInterceptorService, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
