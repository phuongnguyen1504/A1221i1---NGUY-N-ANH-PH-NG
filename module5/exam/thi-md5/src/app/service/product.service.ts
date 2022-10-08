import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/product";
const api_product=environment.url_product
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }
  getAll():Observable<Product[]>{
    return this.http.get<Product[]>(api_product);
  }
  findById(id:number):Observable<Product>{
    return this.http.get<Product>(`${api_product}/${id}`)
  }
  saveProduct(product:Product):Observable<Product>{
    return this.http.post<Product>(api_product,product)
  }
  updateProduct(id:number,product:Product):Observable<Product>{
    return this.http.put<Product>(`${api_product}/${id}`,product)
  }
  deleteProduct(id:number):Observable<Product>{
    return this.http.delete<Product>(`${api_product}/${id}`)
  }
}
