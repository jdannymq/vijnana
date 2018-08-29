package vijnana.respuesta.wrapper.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ConsultaSeguridad extends Request implements Serializable{

	private static final long serialVersionUID = 4492524734886492566L;

	//1
	@JsonProperty("usuario")
	private String usuario;
	
	@JsonProperty("nombreUsuario")
	private String nombreUsuario;
	
	@JsonProperty("contrasenhaUsuario")
	private String contrasenhaUsuario;
	
	@JsonProperty("dominioEmpresa")
	private String dominioEmpresa;
	
	@JsonProperty("rolContexto")
	private String rolContexto;
	
	@JsonProperty("keyContexto")
	private String keyContexto;
	
	@JsonProperty("keyAutentificacion")
	private String keyAutentificacion;
	
	@JsonProperty("keySeguridad")
	private String keySeguridad;
	
	@JsonProperty("keyUsuarioSession")
	private String keyUsuarioSession;

	public ConsultaSeguridad() {
		super();
	}

	public String getUsuario() {
		return usuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getContrasenhaUsuario() {
		return contrasenhaUsuario;
	}

	public String getDominioEmpresa() {
		return dominioEmpresa;
	}

	public String getRolContexto() {
		return rolContexto;
	}

	public String getKeyContexto() {
		return keyContexto;
	}

	public String getKeyAutentificacion() {
		return keyAutentificacion;
	}

	public String getKeySeguridad() {
		return keySeguridad;
	}

	public String getKeyUsuarioSession() {
		return keyUsuarioSession;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setContrasenhaUsuario(String contrasenhaUsuario) {
		this.contrasenhaUsuario = contrasenhaUsuario;
	}

	public void setDominioEmpresa(String dominioEmpresa) {
		this.dominioEmpresa = dominioEmpresa;
	}

	public void setRolContexto(String rolContexto) {
		this.rolContexto = rolContexto;
	}

	public void setKeyContexto(String keyContexto) {
		this.keyContexto = keyContexto;
	}

	public void setKeyAutentificacion(String keyAutentificacion) {
		this.keyAutentificacion = keyAutentificacion;
	}

	public void setKeySeguridad(String keySeguridad) {
		this.keySeguridad = keySeguridad;
	}

	public void setKeyUsuarioSession(String keyUsuarioSession) {
		this.keyUsuarioSession = keyUsuarioSession;
	}
	
}
