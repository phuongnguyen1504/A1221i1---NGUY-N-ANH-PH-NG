import {Component, OnDestroy, OnInit} from '@angular/core';
import {DictionaryServiceService} from "../../service/dictionary-service.service";
import {IWord} from "../../iword";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  word:string;
  mean:string;
  constructor(private dictionaryService:DictionaryServiceService,private activeRoute:ActivatedRoute,private domSantizer:DomSanitizer) { }

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe((paramMap:ParamMap)=>{

      const word=paramMap.get('id');
      console.log(word)
      this.mean=this.translate(word);
      console.log(this.mean);
      this.word=word;
      console.log(this.word);
    })
  }
  translate(value){
    return this.dictionaryService.translate(value);
  }


}
