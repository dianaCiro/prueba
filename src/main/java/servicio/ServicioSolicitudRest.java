package servicio;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.InetOrgPerson;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dominio.AdministradorSolicitudes;
import dominio.Empleado;
import dominio.RespuestaSolicitudVacaciones;
import dominio.SolicitudVacaciones;
import dominio.dto.SolicitudVacacionesDTO;
import ldap.ServicioInformacionEmpleado;
import persistencia.entidad.JefeInmediatoEntidad;

import util.CalculadoraDeDias;


@EnableAutoConfiguration
@Transactional
@RestController
@CrossOrigin
public class ServicioSolicitudRest {
	@Autowired
	AdministradorSolicitudes administrador;

	@Autowired
	private ServicioInformacionEmpleado servicioInformacionEmpleado;

	@RequestMapping(value = "/solicitud/vacaciones", method = RequestMethod.POST)
	@ResponseBody
	public SolicitudVacaciones ingresarSolicitudVacaciones(@RequestBody SolicitudVacacionesDTO solicitudDto) throws NamingException, ParseException {
		return administrador.ingresar(solicitudDto);
	}
	
	@RequestMapping(value = "/revisar/solicitud/vacaciones", method = RequestMethod.GET)
	@ResponseBody
	public List<SolicitudVacaciones> revisarSolicitudesDeVacaciones(@RequestParam String jefeInmediato) {
		return administrador.consultarSolicitudesPendientes(jefeInmediato);
	}

	@CrossOrigin
	@RequestMapping(value = "/revisar/dias/disponibles", method = RequestMethod.GET)
	@ResponseBody
	public double revisarDiasDisponibles() throws NamingException, ParseException {
		Empleado empleado = servicioInformacionEmpleado.obtenerInformacionLdap();
		return CalculadoraDeDias.calcularDiasDisponiblesParaVacaciones(empleado.getFechaIngreso(), Calendar.getInstance());

	}

	@RequestMapping(value = "/listar/jefes", method = RequestMethod.GET)
	public List<JefeInmediatoEntidad> listarJefes() {
		return administrador.consultarjefes();
	}
}
