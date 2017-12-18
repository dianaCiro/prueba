import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService]
})
export class LoginComponent implements OnInit {

  private usuario: string = "";
  private contrasena: string = "";

  constructor(private loginService : LoginService, private router: Router) { }

  ngOnInit() {
  }

  public login (): void{
    this.loginService.login(this.usuario, this.contrasena).subscribe(res => {
      console.log(res);
    });
   // this.router.navigate(['/listarJefes']);
  }
}
