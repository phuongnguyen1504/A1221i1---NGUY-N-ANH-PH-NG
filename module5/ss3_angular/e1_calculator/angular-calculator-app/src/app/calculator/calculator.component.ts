import { Component, OnInit } from '@angular/core';
import {Calc} from "../calc";

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  valuefirst:number;
  valuesecond:number;
  temp:string="";
  result:number;
  isTrue=false;
  iterator="";


  constructor() { }

  ngOnInit(): void {
  }

  addValue(number: any) {
    this.temp+=number;
    this.isTrue=false;
  }

  clear() {
    this.valuesecond=0;
    this.valuefirst=0;
    this.temp="";
  }

  addCalc(s: string) {
    this.valuefirst=Number(this.temp);
    this.isTrue=true;
    this.iterator=s;
    switch (s) {
      case ('+'):
        this.result = this.valuefirst + this.valuesecond;
        break;
      case ('-'):
        this.result = this.valuefirst - this.valuesecond;
        break;
      case ('*'):
        this.result = this.valuefirst* this.valuesecond;
        break;
      case ('/'):
        this.result = this.valuefirst / this.valuesecond;
        break;
      default:
        break;
    }
    this.valuefirst=this.result;
    this.temp=this.result.toString();
  }

  // getTotal(s: string) {
  //   this.value=this.value.
  // }

  addDot() {
    this.temp.concat(".");
  }
}
