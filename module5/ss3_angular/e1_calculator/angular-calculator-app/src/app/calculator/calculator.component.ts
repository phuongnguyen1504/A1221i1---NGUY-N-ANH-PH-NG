import { Component, OnInit } from '@angular/core';
import {Calc} from "../calc";

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  temp:string="";
  result:number;


  constructor() { }

  ngOnInit(): void {
  }

  addValue(number: any) {
    this.temp+=number;
  }

  clear() {
    this.temp="";
  }



  equal() {
    this.temp=eval(this.temp);
  }
}
