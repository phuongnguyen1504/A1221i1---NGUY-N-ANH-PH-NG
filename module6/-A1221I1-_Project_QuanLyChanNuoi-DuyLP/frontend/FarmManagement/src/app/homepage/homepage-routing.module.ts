import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomepageComponent } from './homepage.component';
import {HeaderComponent} from '../shared/header/header.component';
import {LogosliderComponent} from '../shared/logoslider/logoslider.component';
import {FooterComponent} from '../shared/footer/footer.component';
import {HomesiteComponent} from './homesite/homesite.component';

const routes: Routes = [{ path: 'home', component: HomesiteComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  declarations: [
    HeaderComponent,
    LogosliderComponent,
    FooterComponent
  ],
  exports: [RouterModule, HeaderComponent, LogosliderComponent, FooterComponent]
})
export class HomepageRoutingModule { }
