package util;

import java.util.Calendar;

import dominio.exepcion.VacacionesExepcion;

public final class CalculadoraDeDias {
	
	private static final int DIAS_DE_VACACIONES_EN_UN_ANIO = 15;
	private static final int CANTIDAD_MINIMA_DE_DIAS_DE_UN_MES = 28;
	private static final int CANTIDAD_MAXIMA_DE_DIAS_DE_UN_MES = 31;
	private static final int DIA_ADICIONAL = 1;
	private static final int DIAS_DE_UN_MES_CONTABLE = 30;
	private static final int DIAS_DE_ANIO_CONTABLE = 360;
	public static final int DIAS_TOTALES = 15;
	public static final String MENSAJE_NO_HAY_DIAS_DISPONIBLES = "No es posible realizar la solicitud";
	private CalculadoraDeDias(){}
	
	public static int dias360(Calendar fechaInicio, Calendar fechaFin) { 
		int anios = fechaFin.get(Calendar.YEAR) - fechaInicio.get(Calendar.YEAR);  
		int meses = fechaFin.get(Calendar.MONTH) - fechaInicio.get(Calendar.MONTH);  
		int diaInicial=0;
		int diaFinal=0;  
		if(esUnMesDe31Dias(fechaInicio)){  
			diaInicial=DIAS_DE_UN_MES_CONTABLE;  
		} else if(esUnMesDe28Dias(fechaInicio)){  
			diaInicial=DIAS_DE_UN_MES_CONTABLE;  
		}else{  
		    diaInicial=fechaInicio.get(Calendar.DATE);  
		}   
		if(esUnMesDe31Dias(fechaFin)){  
			diaFinal=DIAS_DE_UN_MES_CONTABLE;  
		} else if(esUnMesDe28Dias(fechaFin)){  
		    diaFinal=DIAS_DE_UN_MES_CONTABLE;  
		} else{  
		    diaFinal=fechaFin.get(Calendar.DATE);  
		}   
		int dias = diaFinal-diaInicial;      
		return anios*DIAS_DE_ANIO_CONTABLE+meses*DIAS_DE_UN_MES_CONTABLE+dias;
	}

	private static boolean esUnMesDe28Dias(Calendar fechaInicio) {
		return fechaInicio.get(Calendar.MONTH)==Calendar.FEBRUARY && fechaInicio.get(Calendar.DATE)>=CANTIDAD_MINIMA_DE_DIAS_DE_UN_MES;
	}

	private static boolean esUnMesDe31Dias(Calendar fechaInicio) {
		return fechaInicio.get(Calendar.DATE)==CANTIDAD_MAXIMA_DE_DIAS_DE_UN_MES;
	}
	
	public static double calcularDiasDisponiblesParaVacaciones(Calendar fechaInicio, Calendar fechaFin) {
		return ((double) dias360(fechaInicio,fechaFin)*DIAS_DE_VACACIONES_EN_UN_ANIO/DIAS_DE_ANIO_CONTABLE)+DIA_ADICIONAL;
	}
	
	public static double consultarDiasDisponiblesLuegoDePedir(double diasPedidos, double diasConsumidos) {
		double diasDisponibles = DIAS_TOTALES - diasPedidos - diasConsumidos;
		if(diasDisponibles >= 0){
			return diasDisponibles;
		}
		throw new VacacionesExepcion(MENSAJE_NO_HAY_DIAS_DISPONIBLES);
	}
	
	public static double consultarDiasDisponiblesAntesDePedir(double diasConsumidos) {
		double diasDisponibles = DIAS_TOTALES - diasConsumidos;
		if(diasDisponibles >= 0){
			return diasDisponibles;
		}
		throw new VacacionesExepcion(MENSAJE_NO_HAY_DIAS_DISPONIBLES);
	}
}
