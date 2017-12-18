import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs/Observable';
import { JefeModel } from '../model/JefeModel.model';

@Injectable()
export class ListarJefesService {

  constructor(private http: HttpClient) { }
  
    public obtenerJefes(): Observable<JefeModel[]> {
      debugger;
      return this.http.get<JefeModel[]>("http://localhost:8092/listar/jefes");
       
    }

}
