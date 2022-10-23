import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Category} from '../../model/category';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Product} from '../../model/product';
import {checkInOutValidator} from '../../validator';
import {checkTimeValidator} from '../../validator';

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
    console.log('gia tri out' + product.destOut);
    console.log('gia tri in' + product.destIn);
    this.productService.updateProduct(id, product).subscribe(() => {
      return  this.route.navigate(['/product/list']);
    }, error => {
      console.log(error);
    });
    this.route.navigate(['/product/list']);
  }

  private getProduct(id: number) {
    this.productForm = this.fb.group({
      id: [''],
      type: ['', [Validators.required]],
      nameStation: ['', [Validators.required]],
      destOut: ['', [Validators.required]],
      destIn: ['', [Validators.required]],
      phone: ['', [Validators.required, Validators.pattern(/^(090|093|097)\d{7}$/)]],
      mail: ['', [Validators.required, Validators.email]],
      startDate: ['', [Validators.required, checkTimeValidator]],
      endDate: ['', [Validators.required, checkTimeValidator]],
    });

    return this.productService.findById(id).subscribe(product => {
      console.log(product);
      this.productForm.patchValue(product);

    });
  }
}
