import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {CategoryService} from "../../service/category.service";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  categoryForm:FormGroup;
  id:number;
  constructor(private categoryService:CategoryService,private activatedRoute:ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap:ParamMap)=>{
      this.id=+paramMap.get('id');
      this.getCategory(this.id);
    })
  }

  ngOnInit(): void {
  }
  getCategory(id){
    return this.categoryService.findById(id).subscribe(category=>{
      this.categoryForm=new FormGroup({
        name:new FormControl(category.name)
      })
    })
  }
  updateCategory(id){
    const category=this.categoryForm.value;
    this.categoryService.updateCategory(id,category).subscribe(()=>{
      alert("Cap nhat thanh cong");
    },error => {
      console.log(error);
    })
  }
}
