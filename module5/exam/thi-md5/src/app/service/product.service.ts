import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';

// tslint:disable-next-line:variable-name
const api_product = environment.url_product;

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(api_product);
  }

  findById(id: number): Observable<Product> {
    return this.http.get<Product>(`${api_product}/${id}`);
  }

  saveProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(api_product, product);
  }

  updateProduct(id: number, product: Product): Observable<Product> {
    return this.http.put<Product>(`${api_product}/${id}`, product);
  }

  deleteProduct(id: number): Observable<Product> {
    return this.http.delete<Product>(`${api_product}/${id}`);
  }

  getByKeyValue(key: any, value: any): Observable<Product[]> {
    if (key === 'All' && value !== null) {
      console.log('q');
      return this.http.get<Product[]>(`${api_product}?q=${value}`);
    } else if (value !== null) {
      console.log('value not null');
      return this.http.get<Product[]>(`${api_product}?${key}_like=${value}`);

    }
    return this.http.get<Product[]>(`${api_product}`);
  }

  search(value: any) {
    return this.http.get<Product[]>(`${api_product}/search?q=${value}`);
  }
}