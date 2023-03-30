import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form-admin',
  templateUrl: './form-admin.component.html',
  styleUrls: ['./form-admin.component.css']
})
export class FormAdminComponent implements OnInit{

  username?: any;
  password?: any;

  constructor() { }

  ngOnInit(): void {
  }

  login() {
    // Aquí puedes agregar la lógica de inicio de sesión, como enviar una solicitud HTTP a un servidor para verificar el nombre de usuario y la contraseña.
    console.log('Usuario:', this.username);
    console.log('Contraseña:', this.password);
  }

}
