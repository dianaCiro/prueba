import { Component, OnInit } from '@angular/core';
import { JefeModel } from '../model/JefeModel.model';
import { ListarJefesService } from './listar-jefes.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-listar-jefes',
  templateUrl: './listar-jefes.component.html',
  styleUrls: ['./listar-jefes.component.css'],
  providers: [ListarJefesService]
})
export class ListarJefesComponent implements OnInit {
  public jefes: Array<JefeModel>
  private isEntered : boolean = false;
  constructor(private listarJefesService: ListarJefesService, private router: Router) { }

  ngOnInit() {
    this.obtenerJefes();
  }

  private obtenerJefes(): void {
   this.listarJefesService.obtenerJefes().subscribe(res => {
     this.jefes = res;
   });
  }

  

}
