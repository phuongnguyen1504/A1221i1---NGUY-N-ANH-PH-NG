import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Category} from '../model/category';
const api = environment.url_category;
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<Category[]> {
    return this.http.get<Category[]>(api);

  }

  findById(category: number): Observable<Category> {
    return this.http.get<Category>(`${api}/${category}`);
  }
}
