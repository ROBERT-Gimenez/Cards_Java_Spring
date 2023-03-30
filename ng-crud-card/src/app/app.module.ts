import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { CardsComponent } from './components/cards/cards.component';
import {HttpClientModule} from '@angular/common/http'
import { ReactiveFormsModule } from '@angular/forms';
import { FormAdminComponent } from './components/form-admin/form-admin.component';
@NgModule({
  declarations: [
    AppComponent,
    CardsComponent,
    FormAdminComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    HttpClientModule,
    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
