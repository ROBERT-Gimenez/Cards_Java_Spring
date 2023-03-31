import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-form-admin',
  templateUrl: './form-admin.component.html',
  styleUrls: ['./form-admin.component.css']
})
export class FormAdminComponent implements OnInit{

  formLogin:FormGroup = new FormGroup({});

  constructor() { }

  ngOnInit(): void {
    this.formLogin = new FormGroup({
      username: new FormControl(''),
      password: new FormControl(''),
    })
  }

  login() {
    // Aquí puedes agregar la lógica de inicio de sesión, como enviar una solicitud HTTP a un servidor para verificar el nombre de usuario y la contraseña.
    console.log(this.formLogin.controls['username'].value)
  }

  closeM(){
    this.formLogin.reset();
  }
}
