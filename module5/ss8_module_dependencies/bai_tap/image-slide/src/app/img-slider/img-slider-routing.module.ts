import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ImgSliderComponent } from './img-slider.component';

const routes: Routes = [{ path: '', component: ImgSliderComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ImgSliderRoutingModule { }
