import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ShareModule} from "./share/share.module";
import {HomepageModule} from "./homepage/homepage.module";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {OrderModule} from "./order/order.module";
import {NgxSlickJsModule} from "ngx-slickjs";
import { FocusInvalidInputDirectiveDirective } from './helpers/focus-invalid-input-directive.directive';

@NgModule({
  declarations: [
    AppComponent,
    FocusInvalidInputDirectiveDirective
  ],
    imports: [
      HomepageModule,
      OrderModule,
      NgxSlickJsModule.forRoot({
        links: {
          jquery: 'https://code.jquery.com/jquery-3.4.0.min.js',
          slickJs: 'https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js',
          slickCss: 'https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css',
          slickThemeCss: 'https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css'
        }
      }),
      HttpClientModule,
      // ToastrModule.forRoot(),
        BrowserModule,
        AppRoutingModule,
        ShareModule
    ],
  providers: [

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
