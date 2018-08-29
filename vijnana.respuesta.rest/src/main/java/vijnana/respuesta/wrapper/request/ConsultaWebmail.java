package vijnana.respuesta.wrapper.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name="consultaWebmail")
public class ConsultaWebmail extends Request implements Serializable{

	private static final long serialVersionUID = -4828866572362960670L;
	
	@JsonProperty("idEmail")
	private String idEmail;
	
	@JsonProperty("idAplicacion")
	private String idAplicacion;
	
	public ConsultaWebmail() {
		super();
	}

	public ConsultaWebmail(String keyConsulta, String request, String ipConsulta, String idEmail, String idAplicacion) {
		super(keyConsulta, request, ipConsulta);
		this.idEmail = idEmail;
		this.idAplicacion = idAplicacion;
	}

	public String getIdEmail() {
		return idEmail;
	}

	public String getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdEmail(String idEmail) {
		this.idEmail = idEmail;
	}

	public void setIdAplicacion(String idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	
}
