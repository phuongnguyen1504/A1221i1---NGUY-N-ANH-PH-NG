import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) { }

  findById(id: number) {
    // return this.http.get<Customer>(`${}/${id}`);
  }
}
