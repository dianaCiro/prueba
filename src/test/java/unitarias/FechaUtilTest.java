package unitarias;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import org.junit.Assert;

import org.junit.Test;
import dominio.exepcion.VacacionesExepcion;
import util.CalculadoraDeDias;
import util.Fechautil;

public class FechaUtilTest {

	Calendar fechaPrueba=Calendar.getInstance();

	Calendar fechaInicio = Calendar.getInstance();
	Calendar fechaFin = Calendar.getInstance();

	
	@Test
	public void convertirFechaLdapACalendar() throws ParseException {
		String fechaLdap = "20171108165105.0Z";
		Object fechaCalendar=Fechautil.convertirFechaLdapACalendar(fechaLdap);
		assertTrue(fechaCalendar instanceof Calendar);
	}
	


	@Test
	public void asignarTiempoCero() {
		fechaPrueba.set(Calendar.HOUR, 0);
		fechaPrueba.set(Calendar.MINUTE, 0);
		fechaPrueba.set(Calendar.SECOND, 0);
		fechaPrueba.set(Calendar.MILLISECOND, 0);
		
		assertEquals(Fechautil.asignarTiempoCero(fechaPrueba), fechaPrueba);
		
	}

	@Test
	public void dateToCalendarColombianZone() {
		Date fechaprueba =new Date();
		Calendar fechaCalanedar=Fechautil.dateToCalendarColombianZone(fechaprueba);
		assertTrue(fechaCalanedar  instanceof Calendar);	
	}
	
	@Test
	public void testCalcularDiasMismoMes() {
	fechaInicio.set(Calendar.DATE,1);
	fechaInicio.set(Calendar.MONTH,Calendar.JULY);
	fechaFin.set(Calendar.DATE,10);
	fechaFin.set(Calendar.MONTH,Calendar.JULY);
	int dias = CalculadoraDeDias.dias360(fechaInicio,fechaFin);
	assertEquals(9, dias);
	}
	
	@Test
	public void testCalcular30DiasConMesDe31Dias() {
	fechaInicio.set(Calendar.DATE,10);
	fechaInicio.set(Calendar.MONTH,Calendar.JULY);
	fechaFin.set(Calendar.DATE,10);
	fechaFin.set(Calendar.MONTH,Calendar.AUGUST);
	int dias = CalculadoraDeDias.dias360(fechaInicio,fechaFin);
	assertEquals(30, dias);
	}
	
	@Test
	public void testCalcular30DiasDeFebreroAMarzo() {
	fechaInicio.set(Calendar.DATE,10);
	fechaInicio.set(Calendar.MONTH,Calendar.FEBRUARY);
	fechaFin.set(Calendar.DATE,10);
	fechaFin.set(Calendar.MONTH,Calendar.MARCH);
	int dias = CalculadoraDeDias.dias360(fechaInicio,fechaFin);
	assertEquals(30, dias);
	}
	
	@Test
	public void testCalcularDiasDeVacaciones() {
	fechaInicio.set(Calendar.DATE,10);
	fechaInicio.set(Calendar.MONTH,Calendar.FEBRUARY);
	fechaFin.set(Calendar.DATE,10);
	fechaFin.set(Calendar.MONTH,Calendar.JUNE);
	double dias = CalculadoraDeDias.calcularDiasDisponiblesParaVacaciones(fechaInicio, fechaFin);
	assertEquals(6, dias, 0);
	}
	
	@Test
	public void testCalcularDe31DeEneroA28DeFebrero() {
	fechaInicio.set(Calendar.DATE,31);
	fechaInicio.set(Calendar.MONTH,Calendar.JANUARY);
	fechaFin.set(Calendar.DATE,28);
	fechaFin.set(Calendar.MONTH,Calendar.FEBRUARY);
	int dias = CalculadoraDeDias.dias360(fechaInicio,fechaFin);
	assertEquals(30, dias);
	}
	
	@Test
	public void testCalcularDe30DeJunioA31DeJulio() {
	fechaInicio.set(Calendar.DATE,30);
	fechaInicio.set(Calendar.MONTH,Calendar.JUNE);
	fechaFin.set(Calendar.DATE,31);
	fechaFin.set(Calendar.MONTH,Calendar.JULY);
	int dias = CalculadoraDeDias.dias360(fechaInicio,fechaFin);
	assertEquals(30, dias);
	}
	
	@Test
	public void testCalcularDe28DeFebreroA31DeMarzo() {
	fechaInicio.set(Calendar.DATE,28);
	fechaInicio.set(Calendar.MONTH,Calendar.FEBRUARY);
	fechaFin.set(Calendar.DATE,31);
	fechaFin.set(Calendar.MONTH,Calendar.MARCH);
	int dias = CalculadoraDeDias.dias360(fechaInicio,fechaFin);
	assertEquals(30, dias);
	}
	
	@Test
	public void testMismopDia() {
	fechaInicio=Calendar.getInstance();
	fechaFin=Calendar.getInstance();
	double dias = CalculadoraDeDias.calcularDiasDisponiblesParaVacaciones(fechaInicio, fechaFin);
	assertEquals(1, dias, 0);
	}
	
	@Test
	public void testCalcularDiasDisponiblesLuegoDePedirSiHay() {
	double dias=CalculadoraDeDias.consultarDiasDisponiblesLuegoDePedir(3, 10);
	assertEquals(2, dias, 0);
	}
	
	@Test
	public void testCalcularDiasDisponiblesNoHay() {
	try {
		double dias=CalculadoraDeDias.consultarDiasDisponiblesLuegoDePedir(9, 7);
		fail();
	}catch (VacacionesExepcion e) {			
		Assert.assertEquals("No es posible realizar la solicitud", e.getMessage());
		}
	}
	
	@Test
	public void testCalcularDiasDisponiblesAntesDePedirSiHay() {
	double dias=CalculadoraDeDias.consultarDiasDisponiblesAntesDePedir(12);
	assertEquals(3, dias, 0);
	}
	
	@Test
	public void testCalcularDiasDisponiblesAntesDePedirMal() {
		try {
			double dias=CalculadoraDeDias.consultarDiasDisponiblesAntesDePedir(17);
			fail();
		}catch (VacacionesExepcion e) {			
			Assert.assertEquals("No es posible realizar la solicitud", e.getMessage());
		}
	}
}
