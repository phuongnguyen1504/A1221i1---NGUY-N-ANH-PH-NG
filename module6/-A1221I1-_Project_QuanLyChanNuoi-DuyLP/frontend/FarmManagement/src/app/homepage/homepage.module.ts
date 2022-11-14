import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomepageRoutingModule } from './homepage-routing.module';
import { HomepageComponent } from './homepage.component';
import { NewsdetailComponent } from './newsdetail/newsdetail.component';
import { HomesiteComponent } from './homesite/homesite.component';
import {NgxSlickJsModule} from 'ngx-slickjs';


@NgModule({
  declarations: [HomepageComponent, NewsdetailComponent, HomesiteComponent],
  imports: [
    CommonModule,
    HomepageRoutingModule,
    NgxSlickJsModule
  ]
})
export class HomepageModule { }
