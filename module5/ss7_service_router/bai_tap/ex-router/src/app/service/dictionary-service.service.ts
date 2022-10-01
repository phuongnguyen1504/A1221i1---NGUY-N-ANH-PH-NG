import { Injectable } from '@angular/core';
import {IWord} from "../iword";

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {
  wordList:IWord[]=[
    {
      word:'Hi',
      mean:'Xin Chao'
    },
    {
      word:'Cat',
      mean:'Con meo'
    },
    {
      word:'Dog',
      mean:'Con cho'
    },
  ]
  constructor() { }
  translate(word){
    for (let i of this.wordList){
      if (i.word===word){
        return i.mean;
      }
    }
    return null;
  }
  getAll(){
    return this.wordList;
  }
}
