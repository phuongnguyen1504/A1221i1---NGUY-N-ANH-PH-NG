import {DatePipe} from '@angular/common';

export interface Product {
  id: number;
  type: string;
  nameStation: string;
  destOut: string;
  destIn: string;
  phone: string;
  mail: string;
  startDate: string;
  endDate: string;
}
