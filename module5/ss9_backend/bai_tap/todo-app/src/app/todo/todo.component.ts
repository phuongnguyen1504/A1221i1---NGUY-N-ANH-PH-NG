import { Component, OnInit } from '@angular/core';
import {Todo} from "../todo";
import {FormControl} from "@angular/forms";
import {TodoService} from "../service/todo.service";
import {error} from "protractor";
let _id=1;
@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] =[];
  content=new FormControl();

  constructor(private toDoService:TodoService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll(){
    console.log(this.todos);
    this.toDoService.getAll().subscribe(todo=>{
      this.todos=todo;
    })
  }


  change() {
    const value=this.content.value;
    if(value){
      const todo:Todo={
        content:value,
        complete:false
      };
      this.toDoService.saveToDo(todo).subscribe(()=>{
        this.content.reset();
        alert('tạo thành công');
        this.getAll();
      },error => {
        console.log(error);
      });
    }
  }

  toogleTodo(i: number) {
    let value:Todo={};
    this.toDoService.findById(i+1).subscribe(todo=>{
      value=todo;
      value.complete=!value.complete;

      this.toDoService.updateToDo(i+1,value).subscribe(()=>{
        this.getAll();
      },error=>{
        console.log(error);
      });
    })
  }

  delete(todo: any) {
    let choice=confirm("Are you sure to delete");
    if (choice==true){
      this.toDoService.deleteToDo(todo.id).subscribe(()=>{
        this.getAll();
        alert("da xoa");
      },error=>{
        console.log(error)
      })
    }
  }
}
