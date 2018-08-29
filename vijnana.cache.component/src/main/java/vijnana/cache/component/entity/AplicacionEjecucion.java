package vijnana.cache.component.entity;

public class AplicacionEjecucion {
	
	public static String aplicacionEjecucion;
	
	public AplicacionEjecucion() {
		super();
	}
	
	public String generarAplicacionEjecucion(String nombreAplicacion){
		
		if(aplicacionEjecucion==null){
		
			aplicacionEjecucion = nombreAplicacion;
		
		}
		return aplicacionEjecucion;
	}
	
	public String getAplicacionEjecucion() {
		return aplicacionEjecucion;
	}

	public void setAplicacionEjecucion(String aplicacionEjecucion) {
		AplicacionEjecucion.aplicacionEjecucion = aplicacionEjecucion;
	}
	
}
