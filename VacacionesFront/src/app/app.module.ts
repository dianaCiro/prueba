import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarJefesComponent } from './listar-jefes/listar-jefes.component';
import { LoginComponent } from './login/login.component';
import{FormsModule,ReactiveFormsModule} from '@angular/forms';
import { SolicitudVacacionesComponent } from './solicitud-vacaciones/solicitud-vacaciones.component';
import { TextoInformacionComponent } from './texto-informacion/texto-informacion.component';


@NgModule({
  declarations: [
    AppComponent,
    ListarJefesComponent,
    LoginComponent,
    SolicitudVacacionesComponent,
    TextoInformacionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, 
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
