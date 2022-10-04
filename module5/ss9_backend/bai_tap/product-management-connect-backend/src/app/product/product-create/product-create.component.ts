import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {error} from "protractor";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-product.json-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
    category: new FormControl(),
  });

  constructor(private productService: ProductService,private categoryService:CategoryService) {
  }
  category:Category[]=[];
  ngOnInit() {
    return this.categoryService.getAll();
  }

  submit() {
    const product = this.productForm.value;
    this.productService.saveProduct(product).subscribe(()=>{
      alert("da tao xong");
    },error => {});
    console.log(error);
    this.productForm.reset();
  }

}
