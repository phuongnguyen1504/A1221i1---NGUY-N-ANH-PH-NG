import {Component, Input, OnInit, Output} from '@angular/core';
import {IRatingUnit} from '../irating-unit';

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit {
  ratings: IRatingUnit[] = [];
  rating: IRatingUnit = {value: 1, active: true};

  constructor() {
    for (let i = 1; i <= 10; i++) {
      const obj1: IRatingUnit = {value: i, active: false};
      this.ratings.push(obj1);
      console.log(obj1);
    }

    // this.ratings.forEach(e => {
    //   console.log("val " +e.value)
    // })
  }

  ngOnInit(): void {
  }

  vote(rating: IRatingUnit) {
    for (const item of this.ratings) {
      if (item.value <= rating.value) {
        item.active = true;
      } else {
        item.active = false;
      }
    }
  }
}
