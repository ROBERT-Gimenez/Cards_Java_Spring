import { Component, OnInit } from '@angular/core';
import { Pendientes } from 'src/app/interface/pendientes';
import { PendientesService } from 'src/app/service/pendientes.service';

@Component({
  selector: 'app-lista-pendientes',
  templateUrl: './lista-pendientes.component.html',
  styleUrls: ['./lista-pendientes.component.css']
})
export class ListaPendientesComponent implements OnInit {

  listPending:Pendientes[]=[];
  X?:number;
  constructor(private pendingSer:PendientesService){}

  ngOnInit(): void {
   this.listado()
  }

  listado():any{
    this.pendingSer.allPending().subscribe((res:any)=>{
      console.log(res)
      if(res){
        this.listPending = res;
        this.X=res.length;
      }
    })
  }

  log(item:any , change:any){
    alert(`${item} a solicitado ${change}`)
  }
}
