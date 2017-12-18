import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';

import { NgModule } from '@angular/core';
import { ListarJefesComponent } from './listar-jefes/listar-jefes.component';
import { LoginComponent } from './login/login.component';
import { SolicitudVacacionesComponent } from './solicitud-vacaciones/solicitud-vacaciones.component';


const routes: Routes= [
  {path: '', redirectTo: '/registrarSolicitud', pathMatch:'full'},
  {path : 'listarJefes', component: ListarJefesComponent},
  {path : 'login2', component: LoginComponent},
  {path : 'appComponent', component: AppComponent},
  {path : 'registrarSolicitud', component: SolicitudVacacionesComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }

