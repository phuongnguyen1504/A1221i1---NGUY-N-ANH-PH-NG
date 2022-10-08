import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute} from "@angular/router";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products:Product[];
  constructor(private productService:ProductService) { }

  ngOnInit(): void {
    this.getAll();
  }

  private getAll() {
    return this.productService.getAll().subscribe(product=>{
      this.products=product;
    },error => {
      console.log(error)
    })
  }
}
