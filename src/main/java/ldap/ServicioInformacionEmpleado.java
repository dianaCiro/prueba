package ldap;

import java.text.ParseException;
import java.util.Calendar;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.InetOrgPerson;
import org.springframework.stereotype.Component;

import dominio.Empleado;
import util.Fechautil;

@Component
public class ServicioInformacionEmpleado {

	@Autowired
	LdapTemplate ldapTemplate;

	public Empleado obtenerInformacionLdap() throws NamingException, ParseException {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		InetOrgPerson usuario = (InetOrgPerson) auth.getPrincipal();
		String dn = usuario.getDn() + ",";
		DirContextOperations ctx = ldapTemplate.lookupContext(dn + "ou=medellin");
		Attributes attributes = ctx.getAttributes();
		String cargo = attributes.get("title").get().toString();
		String usuarioCeiba=attributes.get("sAMAccountName").get().toString();
		Calendar fechaIngreso = Fechautil.convertirFechaLdapACalendar(attributes.get("whenCreated").get().toString());
		return new Empleado(cargo,usuarioCeiba ,fechaIngreso,attributes.get("mail").get().toString());
	}

}
