package controller;

import java.text.ParseException;
import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dominio.Empleado;
import ldap.ServicioInformacionEmpleado;

@RestController

public class Prueba {
	
	@Autowired
	ServicioInformacionEmpleado informacionEmpleado;
	
	@RequestMapping(value = "/prueba", method = RequestMethod.GET)
	public Empleado getAllRegisters() throws NamingException, ParseException {
		
		
	     return informacionEmpleado.obtenerInformacionLdap();
		
	}

}
