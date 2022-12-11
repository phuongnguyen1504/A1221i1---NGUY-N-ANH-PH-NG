import {Component, Input, OnInit} from '@angular/core';
import {CartService} from "../../service/cart.service";
import {CustomerService} from "../../service/customer.service";

@Component({
  selector: 'app-cartlist',
  templateUrl: './cartlist.component.html',
  styleUrls: ['./cartlist.component.css']
})
export class CartlistComponent implements OnInit {
  @Input() item: string;
  private cart:any;

  constructor(private cartService:CartService,private customerService:CustomerService) { }

  ngOnInit(): void {

  }
  viewCartById(id:number){
    this.cartService.findById(id).subscribe(data=>{
      this.cart=data;
      console.log(data);
    })
  }

}
