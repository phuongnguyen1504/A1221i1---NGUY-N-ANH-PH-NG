import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ImageGalleryRoutingModule } from './image-gallery-routing.module';
import { ImageGalleryComponent } from './image-gallery.component';
import { ImageCardComponent } from './image-card/image-card.component';


@NgModule({
    declarations: [ImageGalleryComponent, ImageCardComponent],
    exports: [
        ImageGalleryComponent
    ],
    imports: [
        CommonModule,
        ImageGalleryRoutingModule
    ]
})
export class ImageGalleryModule { }
