package util;



import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class Fechautil {
	
	private static final int ANIOS_SIN_CONTAR=1900;
	private Fechautil() {		
	}

	public static Calendar asignarTiempoCero(Calendar fecha) {
		fecha.set(Calendar.HOUR, 0);
		fecha.set(Calendar.MILLISECOND, 0);
		fecha.set(Calendar.SECOND, 0);
		fecha.set(Calendar.MINUTE, 0);
		return fecha;
	}

	public static Calendar dateToCalendarColombianZone(Date date )
	{
	  Calendar cal = Calendar.getInstance();
	  cal.setTime(date);
	  cal.add(Calendar.DAY_OF_YEAR, 1);
	  return cal;
	 }
	public static Calendar convertirFechaLdapACalendar(String fechaLdap) throws ParseException {
		
		Calendar fechaCalendar = Calendar.getInstance();
	    String[] parts = fechaLdap.split("[.]");
	    String dateTimePart = parts[0];  
	    SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddhhmmss");
	    formato.setTimeZone(TimeZone.getTimeZone("GMT"));
	    

	        Date fecha = formato.parse(dateTimePart);
	        fechaCalendar.setTime(fecha); 
	       
	   
	return fechaCalendar;
}

}
