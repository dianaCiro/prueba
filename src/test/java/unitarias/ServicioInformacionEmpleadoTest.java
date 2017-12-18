package unitarias;

import static org.junit.Assert.*;

import java.text.ParseException;

import javax.naming.NamingException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;

import dominio.Empleado;
import ldap.ServicioInformacionEmpleado;

public class ServicioInformacionEmpleadoTest {

	@Autowired
	ServicioInformacionEmpleado servicioInformacionEmpleado;
	
	@Autowired
	LdapTemplate ldapTemplate;
	
	/*@Test
	public void obtenerInformacionLdap() throws NamingException, ParseException {
		
		DirContextOperations ctx = ldapTemplate.lookupContext("cn=Diana Caterine Ciro Henao,ou=medellin");
	    ctx.setAttributeValue("mail", "diana.ciro@ceiba.com.co");
	    ldapTemplate.modifyAttributes(ctx);
	    
		Empleado empleado = servicioInformacionEmpleado.obtenerInformacionLdap();
		assertNotNull(empleado);
	}
*/
}
