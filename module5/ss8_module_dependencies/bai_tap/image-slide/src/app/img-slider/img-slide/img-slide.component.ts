import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-img-slide',
  templateUrl: './img-slide.component.html',
  styleUrls: ['./img-slide.component.css']
})
export class ImgSlideComponent implements OnInit {
  @Input() src='https://via.placeholder.com/1280x420/e91e63/ffffff?text=1';
  constructor() { }

  ngOnInit(): void {
  }

}
