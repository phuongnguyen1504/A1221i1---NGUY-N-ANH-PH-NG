import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ForgotPasswordComponent} from './security/forgot-password/forgot-password.component';
import {HeaderComponent} from './shared/header/header.component';


const routes: Routes = [{ path: '', loadChildren: () => import('./homepage/homepage.module').then(m => m.HomepageModule) }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
