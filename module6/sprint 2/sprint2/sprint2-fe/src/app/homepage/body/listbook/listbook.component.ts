import { Component, OnInit } from '@angular/core';
import {BookService} from "../../../service/book.service";
import {ToastrService} from "ngx-toastr";
import {FormBuilder} from "@angular/forms";
import {Book} from "../../../model/book";

@Component({
  selector: 'app-listbook',
  templateUrl: './listbook.component.html',
  styleUrls: ['./listbook.component.css']
})
export class ListbookComponent implements OnInit {
  indexPagination = 0;
  books:any;
  bookfind:any;
  quantity:number;
  constructor(private bookService:BookService) { }

  ngOnInit(): void {
    this.getAll(this.indexPagination);
    this.quantity=1;
  }
  getAll(indexPagination) {
    this.bookService.getAll(indexPagination).subscribe(
      data => {
        this.books = data;
        console.log(data);
      });
  }

  viewById(id: any) {
    console.log(id);
    this.bookService.findById(id).subscribe(
      data=>{
        this.bookfind=data;
        console.log(this.bookfind);
      }
    )

  }

  addValue() {
    this.quantity++;
  }

  MinusValue() {
    if (this.quantity>1){
      this.quantity--;
    }
  }
}
