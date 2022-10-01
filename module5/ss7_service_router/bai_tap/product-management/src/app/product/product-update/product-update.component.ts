import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  productForm: FormGroup;
  id:number;
  constructor(private productService:ProductService, private activatedRoute:ActivatedRoute,private route:Router) {
    this.activatedRoute.paramMap.subscribe((paramMap:ParamMap)=>{
      this.id=+paramMap.get('id');
      const product = this.productService.findProductById(this.id);
      this.productForm = new FormGroup({
        id: new FormControl(product.id),
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        description: new FormControl(product.description),
      });
    });
  }

  ngOnInit(): void {

  }

  submit() {
    const product=this.productForm.value;
    this.productService.editProduct(product);
    this.productForm.reset();
    this.route.navigateByUrl('/product/list');
  }
}
