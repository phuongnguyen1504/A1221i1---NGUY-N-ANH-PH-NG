import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { CalculatorComponent } from './calculator/calculator.component';
import {FormsModule} from "@angular/forms";
import { ArticleComponent } from './article/article.component';
import { LikeComponent } from './like/like.component';
import {NavbarComponent} from "./hackernews/navbar/navbar.component";
import {FooterComponent} from "./hackernews/footer/footer.component";

@NgModule({
  declarations: [
    AppComponent,
    CalculatorComponent,
    ArticleComponent,
    LikeComponent,
    NavbarComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
