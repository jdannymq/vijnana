package vijnana.respuesta.wrapper.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="respuesta")
public class Respuesta extends Wrapper implements Serializable{
	
	private static final long serialVersionUID = 3226698601034455179L;
	
	public Respuesta() {
		super();
	}
	
	public Respuesta(boolean ok, String tiempoRespuesta, int cantidadResultados, String url, Error error,
			String tipoMetodo, boolean data) {
		super(ok, tiempoRespuesta, cantidadResultados, url, error, tipoMetodo);
		this.data = data;

	}
	
}
