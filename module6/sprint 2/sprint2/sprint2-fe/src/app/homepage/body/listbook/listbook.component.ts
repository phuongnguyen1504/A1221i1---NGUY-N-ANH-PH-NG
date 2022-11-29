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
  books:any;ß
  constructor(private bookService:BookService) { }

  ngOnInit(): void {
    this.getAll(this.indexPagination);
  }
  getAll(indexPagination) {
    this.bookService.getAll(indexPagination).subscribe(
      data => {
        this.books = data;
        console.log(data);
      });
  }

}
