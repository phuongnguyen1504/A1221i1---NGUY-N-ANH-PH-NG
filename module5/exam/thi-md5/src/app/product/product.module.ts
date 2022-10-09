import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import { ProductComponent } from './product.component';
import { ProductCreateComponent } from './product-create/product-create.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductDeleteComponent } from './product-delete/product-delete.component';
import { ProductEditComponent } from './product-edit/product-edit.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ProductSortComponent } from './product-sort/product-sort.component';



@NgModule({
  declarations: [ProductComponent, ProductCreateComponent, ProductListComponent, ProductDeleteComponent, ProductEditComponent, ProductSortComponent],
  imports: [
    CommonModule,
    ProductRoutingModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class ProductModule { }
