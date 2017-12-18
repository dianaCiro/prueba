package dominio;

import java.util.Calendar;

public class SolicitudVacaciones {
	
	private int id;
	private String tipo;	
	private String jefeInmediato;
	private int cantidadDeDias;
	private int estadoSolicitud;
	private int estadoContabilidad;	
	private Calendar fechaDeSolicitudDeinicio;
	private Calendar fechaDeSolicitudFin;
	private Calendar fechaDeRegreso;
	private String usuarioEmpleado;
	
	

	public Calendar getFechaDeSolicitudDeinicio() {
		return fechaDeSolicitudDeinicio;
	}

	public Calendar getFechaDeSolicitudFin() {
		return fechaDeSolicitudFin;
	}

	public Calendar getFechaDeRegreso() {
		return fechaDeRegreso;
	}

	public int getCantidadDeDias() {
		return cantidadDeDias;
	}

	public String getJefeInmediato() {
		return jefeInmediato;
	}
	

	public int getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public int getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public int getEstadoContabilidad() {
		return estadoContabilidad;
	}

	public String getUsuarioEmpleado() {
		return usuarioEmpleado;
	}

	public SolicitudVacaciones(Calendar fechaDeSolicitudDeinicio, Calendar fechaDeSolicitudFin, String jefeInmediato,int estadoSolicitud,String usuarioEmpleado) {
		this.fechaDeSolicitudDeinicio = fechaDeSolicitudDeinicio;
		this.fechaDeSolicitudFin = fechaDeSolicitudFin;
		this.jefeInmediato = jefeInmediato;
		this.estadoSolicitud=estadoSolicitud;
		this.usuarioEmpleado=usuarioEmpleado;
	}

	
	public SolicitudVacaciones(String tipo, int cantidadDeDias, String usuarioEmpleado) {
		this.tipo = tipo;
		this.cantidadDeDias = cantidadDeDias;
		this.usuarioEmpleado = usuarioEmpleado;
	}

	public void setFechaDeRegreso(Calendar fechaDeRegreso) {
		this.fechaDeRegreso = fechaDeRegreso;
	}

	public void setCantidadDeDias(int cantidaddeDias) {
		cantidadDeDias = cantidaddeDias;
	}

	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setEstadoSolicitud(int estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	public void setEstadoContabilidad(int estadoContabilidad) {
		this.estadoContabilidad = estadoContabilidad;
	}



	
}
