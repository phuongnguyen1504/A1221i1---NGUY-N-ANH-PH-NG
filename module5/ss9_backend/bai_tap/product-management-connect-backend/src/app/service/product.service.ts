import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const api_product=`${environment.apiProduct}`
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) {
  }


  getAll():Observable<Product[]> {
    return this.http.get<Product[]>(api_product);
  }


  // @ts-ignore
  saveProduct(product):Observable<Product> {
    this.http.post<Product>(api_product,product);
  }

  findById(id: number):Observable<Product> {
    return this.http.get<Product>(`${api_product}/${id}`);
  }

  updateProduct(id: number, product: Product):Observable<Product> {
    return this.http.put<Product>(`${api_product}/${id}`,product);
  }

  deleteProduct(id: number):Observable<Product> {
    return this.http.delete<Product>(`${api_product}/${id}`);
  }
}
