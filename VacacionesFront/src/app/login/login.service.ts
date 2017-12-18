import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs/Observable';

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) { }

  public login(nombre : String, contraseña : String):Observable <Object> {
    return this.http.post("http://localhost:8092/login2",JSON.stringify({ username: nombre, password: contraseña }));
  }

}
