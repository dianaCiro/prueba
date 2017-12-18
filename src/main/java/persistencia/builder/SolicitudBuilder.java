package persistencia.builder;

import dominio.SolicitudVacaciones;
import persistencia.entidad.SolicitudEntidad;

public final class SolicitudBuilder {
	
	private SolicitudBuilder(){
	}
	
	public static SolicitudVacaciones convertirADominio(SolicitudEntidad solicitudEntity) {
		if (solicitudEntity == null) {
			return null;
		}else{
			if(solicitudEntity.getFechaDeSolicitudDeinicio()!=null){
			SolicitudVacaciones solicitud= new SolicitudVacaciones(solicitudEntity.getFechaDeSolicitudDeinicio(), solicitudEntity.getFechaDeSolicitudFin(), solicitudEntity.getJefeInmediato(),solicitudEntity.getEstadoSolicitud(),solicitudEntity.getUsuario());
			solicitud.setCantidadDeDias(solicitudEntity.getCantidadDeDias());
			solicitud.setFechaDeRegreso(solicitudEntity.getFechaDeRegreso());
			solicitud.setTipo(solicitudEntity.getTipo());
			solicitud.setEstadoContabilidad(solicitudEntity.getEstadoContabilidad());
				return solicitud;
			}
			else{
				return new SolicitudVacaciones(solicitudEntity.getTipo(),solicitudEntity.getCantidadDeDias(),solicitudEntity.getUsuario());
			}
		}
	}

	public static SolicitudEntidad convertirAEntity(SolicitudVacaciones solicitud) {
		SolicitudEntidad solicitudEntity = new SolicitudEntidad();
		solicitudEntity.setCantidadDeDias(solicitud.getCantidadDeDias());
		solicitudEntity.setFechaDeRegreso(solicitud.getFechaDeRegreso());
		solicitudEntity.setFechaDeSolicitudDeinicio(solicitud.getFechaDeSolicitudDeinicio());
		solicitudEntity.setFechaDeSolicitudFin(solicitud.getFechaDeSolicitudFin());
		solicitudEntity.setJefeInmediato(solicitud.getJefeInmediato());	
		return solicitudEntity;
	}


}
