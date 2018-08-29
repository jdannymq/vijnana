package vijnana.utilidades.component.utilidades;

public class AppCalcularTiempo{

	public static String setearTiempoRespuesta(Long inicio) {
		String tiempo="";
		Long tiempoRespuesta = System.currentTimeMillis() - inicio;
		tiempo = tiempoRespuesta.toString();
		return tiempo;
	}
}
