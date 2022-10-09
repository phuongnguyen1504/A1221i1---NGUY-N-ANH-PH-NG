import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  productForm: FormGroup;
  categories: Category[];
  id: number;
  constructor(private productService: ProductService, private categoryService: CategoryService, private route: Router,
              private activeRoutes: ActivatedRoute) {
    this.activeRoutes.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    });

  }

  ngOnInit(): void {
    this.activeRoutes.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    });
  }


  onSubmit(id: number) {
    this.productService.deleteProduct(id).subscribe(() => {
    }, error => {
      console.log(error);
    });
    this.route.navigate(['/product/list']);
  }

  private getProduct(id: number) {
    return this.productService.findById(id).subscribe(product => {
      this.productForm = new FormGroup({
        id: new FormControl(product.id, ),
        name: new FormControl(product.name, [Validators.required]),
        price: new FormControl(product.price, [Validators.required]),
        description: new FormControl(product.description, [Validators.required]),
        category: new FormControl(product.category, [Validators.required]),
      });
    });
  }
}
