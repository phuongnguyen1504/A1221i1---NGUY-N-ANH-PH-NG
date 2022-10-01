import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionayPageComponent} from "./dictionary/dictionay-page/dictionay-page.component";
import {DictionaryDetailComponent} from "./dictionary/dictionary-detail/dictionary-detail.component";


const routes: Routes = [
  {
    path:'dictionary/list',
    component:DictionayPageComponent
  },
  {
    path:'dictionary/detail/:id',
    component:DictionaryDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
