import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ColorComponent } from './color/color.component';
import {ColorPickerModule} from "ngx-color-picker";

@NgModule({
  declarations: [
    AppComponent,
    ColorComponent
  ],
  imports: [
    BrowserModule,
    ColorPickerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
