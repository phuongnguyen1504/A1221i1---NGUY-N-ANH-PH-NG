import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Category} from "../model/category";
const API_Url=`${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http:HttpClient) { }
  getAll():Observable<Category[]>{
    return this.http.get<Category[]>(API_Url+'/categories');
  }
  saveCategory(category):Observable<Category>{
    return this.http.post<Category>(API_Url+'/categories',category);
  }
  findById(id):Observable<Category>{
    return this.http.get<Category>(`${API_Url}/categories/${id}`);
  }
  updateCategory(id,category):Observable<Category>{
    return this.http.put<Category>(`${API_Url}/categories/${id}`,category);
  }
  deleteCategory(id):Observable<Category>{
    return this.http.delete<Category>(`${API_Url}/categories/${id}`);
  }
}
