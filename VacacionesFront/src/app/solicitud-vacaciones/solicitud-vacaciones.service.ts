import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Headers,Http,Response} from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import swal from 'sweetalert2';
import { JefeModel } from '../model/JefeModel.model';

@Injectable()
export class SolicitudVacacionesService {

  constructor(private http: HttpClient) { }
  
    public registrarSolicitud(solicitud): Observable<any> {
      const headers = new Headers({'Content-type':'application/json'}); 
      return this.http.post("http://localhost:8092/solicitud/vacaciones", solicitud)
    }

    public obtenerJefes(): Observable<JefeModel[]> {
      debugger;
      return this.http.get<JefeModel[]>("http://localhost:8092/listar/jefes");
       
    }

    private extractData(res:Response){           
      return res.json()||{};
    }
  
    private handleError(error:Response | any){    
      let errMsg: string;
      if(error instanceof Response){
        const body =error.json() || '';
        const err = body.error|| JSON.stringify(body);
        errMsg = `${error.status} - ${error.statusText || ''} ${err} `;
        alert(body.message);
      }else{
        errMsg =error.message ? error.message : error.toString();
      }
      console.error(errMsg);
      return Observable.throw(errMsg);
    }



}
