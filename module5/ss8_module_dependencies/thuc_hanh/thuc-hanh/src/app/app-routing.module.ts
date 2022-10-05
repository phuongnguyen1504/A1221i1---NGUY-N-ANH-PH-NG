import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [{ path: 'image-gallery', loadChildren: () => import('./image-gallery/image-gallery.module').then(m => m.ImageGalleryModule) },
  { path: 'product', loadChildren: () => import('./product/product.module').then(m => m.ProductModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
