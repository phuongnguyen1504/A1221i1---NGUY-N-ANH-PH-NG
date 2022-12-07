import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShareRoutingModule } from './share-routing.module';
import { ShareComponent } from './share.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './security/login/login.component';
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
    declarations: [ShareComponent, HeaderComponent, FooterComponent, LoginComponent],
  exports: [
    HeaderComponent,
    FooterComponent
  ],
    imports: [
        CommonModule,
        ShareRoutingModule,
        ReactiveFormsModule
    ]
})
export class ShareModule { }
