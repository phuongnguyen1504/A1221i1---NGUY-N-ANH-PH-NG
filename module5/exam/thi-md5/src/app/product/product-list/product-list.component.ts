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
  p = 1;

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
    if (this.value == null) {
      return  this.productService.getAll().subscribe(product => {
        this.products = product;
        console.log(this.key, this.value);
      });
    } else {
      return this.productService.search(this.value).subscribe(product => {
        this.products = product;
        console.log(this.key, this.value);
      });
    }
  }

  onChange(event: any) {
    this.key = event;
  }

  changeInput(event: any) {
    this.value = event;
  }
}
// search() {
//   const nameProduct = this.formSearch.get('nameProduct').value || '';
//   let dateEnd = this.formSearch.get('dateEnd').value;
//   let dateImportBegin = this.formSearch.get('dateImportBegin').value;
//   let dateImportEnd = this.formSearch.get('dateImportEnd').value;
//   if (dateEnd === null) {
//     dateEnd = this.datepipe.transform(new Date(), 'yyyy/MM/dd');
//   }
//   if (dateImportBegin === null) {
//     dateImportBegin = this.datepipe.transform(new Date('1000-01-01'), 'yyyy/MM/dd');
//   }
//   if (dateImportEnd === null) {
//     dateImportEnd = this.datepipe.transform(new Date(), 'yyyy/MM/dd');
//   }
//   this.productService.search(nameProduct, dateEnd, dateImportBegin, dateImportEnd)
//     .subscribe(
//       data => {
//         this.products = data;
//       }
//     );
