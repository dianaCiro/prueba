package dominio.dto;

import java.util.Calendar;
import java.util.Date;

public class SolicitudVacacionesDTO {
	 private  Calendar fechaInicial;
	 private Calendar fechaFinal;
	 private String jefeInmediato;
	 private String tipo;	
	 private Date fechaInicio;
	 private Date fechaFin;
	 
	 
	 public String getTipo() {
		return tipo;
	}
	
	public Calendar getFechaInicial() {
		return fechaInicial;
	}
	
	public void setJefeInmediato(String jefeInmediato) {
		this.jefeInmediato = jefeInmediato;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Calendar getFechaFinal() {
		return fechaFinal;
	}
	public String getJefeInmediato() {
		return jefeInmediato;
	}
	public void setFechaInicial(Calendar fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public void setFechaFinal(Calendar fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	
	
	
}
