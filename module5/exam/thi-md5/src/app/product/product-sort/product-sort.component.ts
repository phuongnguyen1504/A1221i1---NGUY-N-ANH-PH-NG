import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-product-sort',
  templateUrl: './product-sort.component.html',
  styleUrls: ['./product-sort.component.css']
})
export class ProductSortComponent implements OnInit {
  formSearch: FormGroup;
  key: string;
  value: any;
  constructor(private activatedRoute: ActivatedRoute, private router: Router) {
    console.log(this.key, this.value);
  }

  ngOnInit(): void {
    console.log(this.key, this.value);
  }

  search(value: string) {
    this.router.navigateByUrl(`/product/list?${(this.key)}_like=${value}`);
  }
}
