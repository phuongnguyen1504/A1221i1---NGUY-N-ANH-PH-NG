import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Category} from '../../model/category';
import iziToast from '../../../assets/izitoast';

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
    const choice = confirm(`Ban dong y xoa thong tin xe khach co so xe ${id}`);
    if (choice === true) {
      this.productService.deleteProduct(id).subscribe(() => {
        return this.route.navigate(['/product/list']);
      }, error => {
        console.log(error);
      });
    }
    // this.route.navigate(['/product/list']);
  }

  private getProduct(id: number) {
    return this.productService.findById(id).subscribe(product => {
      this.productForm = new FormGroup({
        id: new FormControl(product.id, ),
        type: new FormControl(product.type, ),
        nameStation: new FormControl(product.nameStation, [Validators.required]),
        out: new FormControl(product.destOut, [Validators.required]),
        in: new FormControl(product.destIn, [Validators.required]),
        phone: new FormControl(product.phone, [Validators.required]),
        mail: new FormControl(product.mail, [Validators.required]),
        startDate: new FormControl(product.startDate, [Validators.required]),
        endDate: new FormControl(product.endDate, [Validators.required]),
      });
    });
  }
}
