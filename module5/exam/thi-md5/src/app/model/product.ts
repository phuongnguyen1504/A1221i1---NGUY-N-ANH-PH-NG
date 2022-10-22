import {DatePipe} from '@angular/common';

export interface Product {
  id: number;
  type: string;
  nameStation: string;
  dateOut: string;
  dateIn: string;
  phone: string;
  mail: string;
  startDate: string;
  endDate: string;
}
