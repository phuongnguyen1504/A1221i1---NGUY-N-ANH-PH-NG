import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {passValidator} from '../../validator';
import {Category} from '../../model/category';
import iziToast from 'izitoast';
import {Product} from '../../model/product';
import {ActivatedRoute, Route, Router, Routes} from '@angular/router';


@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
// rfRegister: FormGroup;
// country=['Anh','Mỹ','Hàn Quốc'];
// constructor(private _formBuilder:FormBuilder) {
//   this.rfRegister=this._formBuilder.group({
//     email:['',[Validators.required,Validators.email]],
//     password:['',[Validators.required,Validators.minLength(6)]],
//     confirm_password:['',[Validators.required,passValidator]],
//     country:['',Validators.required],
//     age:['',[Validators.required,Validators.min(18)]],
//     gender:['',Validators.required],
//     phone:['',[Validators.required,Validators.pattern(/^\+84\d{9,10}$/)]]
//   });
//   this.rfRegister.controls['password'].valueChanges
//     .subscribe(
//       x => this.rfRegister.controls['confirm_password'].updateValueAndValidity()
//     )
// }
export class ProductCreateComponent implements OnInit {
  @ViewChild('editModal') editModal: TemplateRef<any>; // Note: TemplateRef
  productForm: FormGroup;
  categories: Category[];
  constructor(private productService: ProductService, private categoryService: CategoryService, private route: Router) {

    this.productForm = new FormGroup({
      id: new FormControl('', ),
      name: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      category: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(categories => {
      this.categories = categories;
    }, error => {
      console.log(error);
    });

  }

  onSubmit() {
    const product: Product = this.productForm.value;
    this.productService.saveProduct(product).subscribe(() => {
    }, error => {
      console.log(error);
    });
    // this.productForm.reset();
    this.route.navigateByUrl('/product/list');
  }
}
