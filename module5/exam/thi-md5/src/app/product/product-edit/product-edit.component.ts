import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Category} from '../../model/category';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productForm: FormGroup;
  categories: Category[];
  id: number;
  constructor(private fb: FormBuilder , private productService: ProductService, private categoryService: CategoryService,
              private route: Router,
              private activeRoutes: ActivatedRoute) {

    this.activeRoutes.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    });
  }

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(categories => {
      this.categories = categories;
    }, error => {
      console.log(error);
    });
    this.activeRoutes.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    });

  }

  onSubmit(id) {
    const product: Product = this.productForm.value;
    this.productService.updateProduct(id, product).subscribe(() => {
    }, error => {
      console.log(error);
    });
    this.route.navigate(['/product/list']);
  }

  private getProduct(id: number) {
    this.productForm = this.fb.group({
      id:[''],
      name: ['', [Validators.required]],
      price: ['', [Validators.required]],
      description: ['',[Validators.required]],
      category: ['', [Validators.required]],
    });
    return this.productService.findById(id).subscribe(product => {
      console.log(product);
      this.productForm.patchValue(product);

    });
  }
}
