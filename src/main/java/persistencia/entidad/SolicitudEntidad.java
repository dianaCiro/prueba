package persistencia.entidad;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity(name = "Solicitud")
@NamedQueries({
	@NamedQuery(name = "Solicitud.BuscarSolicitudesPendientes", query = "SELECT solicitud from Solicitud solicitud where solicitud.estadoSolicitud = 1 AND solicitud.jefeInmediato = :jefeInmediato"),
	@NamedQuery(name = "Solicitud.BuscarSolicitudesAprobadas", query = "SELECT solicitud from Solicitud solicitud where solicitud.estadoSolicitud = 2 AND solicitud.jefeInmediato = :jefeInmediato"),
	@NamedQuery(name = "Solicitud.BuscarSolicitudesRechazadas", query = "SELECT solicitud from Solicitud solicitud where solicitud.estadoSolicitud = 3 AND solicitud.jefeInmediato = :jefeInmediato")
})
public class SolicitudEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private Calendar fechaDeSolicitudDeinicio;
	@Column
	private Calendar fechaDeSolicitudFin;
	@Column
	private Calendar fechaDeRegreso;
	@Column
	private int cantidadDeDias;
	@Column
	private String jefeInmediato;
	@Column
	private int estadoSolicitud;
	@Column
	private int estadoContabilidad;	
	@Column
	private String usuario;
	@Column
	private String tipo;

	public int getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstado(int estado) {
		this.estadoSolicitud = estado;
	}

	public Long getId() {
		return id;
	}

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

	public void setId(Long id) {
		this.id = id;
	}

	public void setFechaDeSolicitudDeinicio(Calendar fechaDeSolicitudDeinicio) {
		this.fechaDeSolicitudDeinicio = fechaDeSolicitudDeinicio;
	}

	public void setFechaDeSolicitudFin(Calendar fechaDeSolicitudFin) {
		this.fechaDeSolicitudFin = fechaDeSolicitudFin;
	}

	public void setFechaDeRegreso(Calendar fechaDeRegreso) {
		this.fechaDeRegreso = fechaDeRegreso;
	}

	public void setCantidadDeDias(int cantidaddeDias) {
		cantidadDeDias = cantidaddeDias;
	}

	public void setJefeInmediato(String jefeInmediato) {
		this.jefeInmediato = jefeInmediato;
	}

	public int getEstadoContabilidad() {
		return estadoContabilidad;
	}

	public void setEstadoContabilidad(int estadoContabilidad) {
		this.estadoContabilidad = estadoContabilidad;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setEstadoSolicitud(int estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

}
