import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { PendientesService } from 'src/app/service/pendientes.service';

@Component({
  selector: 'app-form-request',
  templateUrl: './form-request.component.html',
  styleUrls: ['./form-request.component.css']
})
export class FormRequestComponent implements OnInit {

  formResques:FormGroup = new FormGroup({});

  constructor(private pending:PendientesService) { }

  ngOnInit(): void {
    this.formResques = new FormGroup({
      user_name: new FormControl(''),
      type_request: new FormControl(''),
    })
  }
  save(){
    this.pending.addedPending(this.formResques.value).subscribe(res=> {
      if(res){
        this.formResques.reset();
      }
    })
  }

  closeM(){
    this.formResques.reset();
  }
}
