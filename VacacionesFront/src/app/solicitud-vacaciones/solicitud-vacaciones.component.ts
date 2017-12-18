import { Component, OnInit } from '@angular/core';
import { SolicitudVacacionesService } from './solicitud-vacaciones.service';
import swal, { SweetAlertOptions } from 'sweetalert2';
import { ListarJefesService } from '../listar-jefes/listar-jefes.service';
import { JefeModel } from '../model/JefeModel.model';

@Component({
  selector: 'app-solicitud-vacaciones',
  templateUrl: './solicitud-vacaciones.component.html',
  styleUrls: ['./solicitud-vacaciones.component.css'],
  providers: [SolicitudVacacionesService, ListarJefesService]
})

export class SolicitudVacacionesComponent implements OnInit {

  public jefes: Array<JefeModel>
  private isEntered : boolean = false;

  selectedoption: string = "En días";
  selectedjefe: string = "";
  fechaInicio:any; 
  fechaFin:any; 
  cond:string ="En días";
  fechaRegreso:any;
  options: string[] = ["En días", "En dinero"]; 
  dto:any={};
  solicitud:any={};
  date:any;
  datestring:String;

  constructor(private solicitudVacacionesService : SolicitudVacacionesService, private listarJefesService: ListarJefesService) { }

  ngOnInit() {
    this.obtenerJefes();
  }

  private obtenerJefes(): void {
   this.listarJefesService.obtenerJefes().subscribe(res => {
     this.jefes = res;
   });
  }

  reiniciar(){
    this.dto={};
    location.reload();
  }

  ingresoSolicitud(){   
    debugger;
    this.dto.tipo=this.selectedoption;
    this.dto.jefeInmediato=this.selectedjefe;
    this. solicitudVacacionesService.registrarSolicitud(this.dto).subscribe(res=>{      
      this.solicitud=res;
      var date = new Date(parseInt(this.solicitud.fechaDeRegreso)); 
      var time= date.toDateString();      
      swal({
        title: 'Excelente!',
        text: 'Su Solicitud se ha guardado Correctamente,Solicitó '+this.solicitud.cantidadDeDias+' días de vacaciones,Retoma su labores el '+time+'',
        type: 'success',
        confirmButtonColor: '#117b66',
        confirmButtonText: 'Aceptar'      
      });
    });
    this.dto={};
  }

  diferenciaDias(){
    var fechaActual=new Date();
    var fecha = new Date(this.dto.fechaInicio);
    var manana= new Date();
    manana.setDate(fechaActual.getDate()+1);
        
    if(fecha<fechaActual){
        swal({
            title: 'Atención!',
            text: 'Eligio una fecha menor a la actual,Se establecerá como inicial la del dia de hoy',
            type: 'info',
            confirmButtonColor: '#117b66',
            confirmButtonText: 'Aceptar'
        })
       this.dto.fechaInicio=manana.getDate();
    }
    if(this.dto.fechaInicio==this.dto.fechaFin){
        swal({
          title: 'Atención!',
          text: 'Solo será un día de vacaciones',
          type: 'info',
          confirmButtonColor: '#117b66',
          confirmButtonText: 'Aceptar'
        })
      }
      else if (this.dto.fechaInicio>this.dto.fechaFin){
        swal({
          title: 'Atención!',
          text: 'la Fecha Inicial es mayor a la Final,se igualaran las fechas ',
          type: 'warning',
          confirmButtonColor: '#117b66',
          confirmButtonText: 'Aceptar'
        })
        this.dto.fechaInicio=this.dto.Final;
      }   
     
      
    }
}
