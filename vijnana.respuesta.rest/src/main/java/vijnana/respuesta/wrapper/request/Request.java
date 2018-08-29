package vijnana.respuesta.wrapper.request;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name="request")
public abstract class  Request  {
	
	@JsonProperty("remoteAddr")
	private String remoteAddr;
	
	@JsonProperty("remoteHost")
	private String remoteHost;
	
	@JsonProperty("request")
	private String request;
	
	@JsonProperty("nombreAplicacion")
	private String nombreAplicacion;
	
	@JsonProperty("nombreAplicacionProducto")
	private String nombreAplicacionProducto;
	
	@JsonProperty("nombreAplicacionProductoServicio")
	private String nombreAplicacionProductoServicio;
	
	@JsonProperty("metodoHttp")
	private String metodoHttp;
	
	@JsonProperty("keySession")
	private String keySession;
	
	
	public Request() {
		super();
	}

	public Request(String keyConsulta, String request, String ipConsulta) {
		super();
		this.request = request;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public String getRequest() {
		return request;
	}

	public String getNombreAplicacion() {
		return nombreAplicacion;
	}

	public String getNombreAplicacionProducto() {
		return nombreAplicacionProducto;
	}

	public String getNombreAplicacionProductoServicio() {
		return nombreAplicacionProductoServicio;
	}

	public String getMetodoHttp() {
		return metodoHttp;
	}

	public String getKeySession() {
		return keySession;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}

	public void setNombreAplicacionProducto(String nombreAplicacionProducto) {
		this.nombreAplicacionProducto = nombreAplicacionProducto;
	}

	public void setNombreAplicacionProductoServicio(String nombreAplicacionProductoServicio) {
		this.nombreAplicacionProductoServicio = nombreAplicacionProductoServicio;
	}

	public void setMetodoHttp(String metodoHttp) {
		this.metodoHttp = metodoHttp;
	}

	public void setKeySession(String keySession) {
		this.keySession = keySession;
	}
	
}
