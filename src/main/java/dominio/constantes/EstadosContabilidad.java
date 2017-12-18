package dominio.constantes;

public enum EstadosContabilidad {
	INGRESADA_A_NOMINA(1), PENDIENTE_POR_INGRESAR_A_NOMINA(2);
	private Integer value;
	
	EstadosContabilidad(Integer a){
		this.value = a;
	}
	
	public Integer getValue() {
		return value;
	}	
	
}