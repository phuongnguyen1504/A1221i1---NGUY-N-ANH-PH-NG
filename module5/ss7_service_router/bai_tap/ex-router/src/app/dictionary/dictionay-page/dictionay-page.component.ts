import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService} from "../../service/dictionary-service.service";
import {IWord} from "../../iword";

@Component({
  selector: 'app-dictionay-page',
  templateUrl: './dictionay-page.component.html',
  styleUrls: ['./dictionay-page.component.css']
})
export class DictionayPageComponent implements OnInit {
  wordList:IWord[]=[];
  constructor(private dictionaryService:DictionaryServiceService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll(){
    this.wordList=this.dictionaryService.getAll();
  }

}
