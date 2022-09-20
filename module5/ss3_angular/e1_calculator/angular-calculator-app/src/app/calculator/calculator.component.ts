import { Component, OnInit } from '@angular/core';
import {Calc} from "../calc";

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  value:string;

  constructor() { }

  ngOnInit(): void {
  }

  addValue(number: any) {
    this.value+=number;
  }

  clear() {
    this.value="";
  }
}
