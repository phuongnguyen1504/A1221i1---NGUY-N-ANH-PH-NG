import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Product} from '../../model/product';
import {FormBuilder} from '@angular/forms';
import {CategoryService} from '../../service/category.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[];
  key: any|null = null;
  value: any|null = null;

  constructor(private fb: FormBuilder , private productService: ProductService, private categoryService: CategoryService,
              private route: Router,
              private activeRoutes: ActivatedRoute) {
    this.getAll();
  }

  ngOnInit(): void {
    this.getAll();
  }

  private getAll() {
    return this.search();
  }

  search() {
    return this.productService.getByKeyValue(this.key, this.value).subscribe(product => {
      this.products = product;
      console.log(this.key, this.value);
    });
  }

  onChange(event: any) {
    this.key = event;
  }

  changeInput(event: any) {
    this.value = event;
  }
}
