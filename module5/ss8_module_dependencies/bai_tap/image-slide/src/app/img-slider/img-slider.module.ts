import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ImgSliderRoutingModule } from './img-slider-routing.module';
import { ImgSliderComponent } from './img-slider.component';
import { ImgSlideComponent } from './img-slide/img-slide.component';


@NgModule({
    declarations: [ImgSliderComponent, ImgSlideComponent],
    exports: [
        ImgSliderComponent
    ],
    imports: [
        CommonModule,
        ImgSliderRoutingModule
    ]
})
export class ImgSliderModule { }
