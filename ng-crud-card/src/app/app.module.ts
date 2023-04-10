import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { CardsComponent } from './components/cards/cards.component';
import {HttpClientModule} from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormAdminComponent } from './components/form-admin/form-admin.component';
import { AppRoutingModule } from './app-routing.module';
import { CommonModule } from '@angular/common';
import { ListaPendientesComponent } from './components/lista-pendientes/lista-pendientes.component';
import { FormRequestComponent } from './components/form-request/form-request.component';
@NgModule({
  declarations: [
    AppComponent,
    CardsComponent,
    FormAdminComponent,
    ListaPendientesComponent,
    FormRequestComponent
    
  ],
  imports: [
    BrowserModule,
    RouterModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    CommonModule
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
