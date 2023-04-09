import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CardsComponent } from './components/cards/cards.component';
import { ListaPendientesComponent } from './components/lista-pendientes/lista-pendientes.component';

const routes: Routes = [
  /*   {path:'home', loadChildren: () => import('./components/cards/cards.component').then(m => m.CardsComponent)},
    {path:'pendientes', loadChildren: () => import('./components/lista-pendientes/lista-pendientes.component').then(m => m.ListaPendientesComponent)},
   
    {path:'', redirectTo:'home', pathMatch:'full'} */
    { path: 'home', component: CardsComponent },
    { path: 'pendientes', component: ListaPendientesComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' }
  ];
  
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }
  