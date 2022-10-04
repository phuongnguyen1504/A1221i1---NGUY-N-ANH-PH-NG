import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Todo} from "../todo";
const api=`${environment.API_URL}`;
@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private http:HttpClient) { }
  getAll():Observable<Todo[]>{
    return this.http.get<Todo[]>(`${api}`);
  }
  saveToDo(todo):Observable<Todo>{
    console.log(api)
    console.log(todo)
    return this.http.post(`${api}`,todo);
  }
  findById(id):Observable<Todo>{
    return this.http.get<Todo>(`${api}/${id}`);
  }
  updateToDo(id,todo):Observable<Todo>{
    return this.http.put<Todo>(`${api}/${id}`, todo);

  }
  deleteToDo(id):Observable<Todo>{
    return this.http.delete<Todo>(`${api}/${id}`)
  }
}
