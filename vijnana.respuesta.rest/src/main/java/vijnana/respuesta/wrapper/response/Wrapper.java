package vijnana.respuesta.wrapper.response;

import org.codehaus.jackson.annotate.JsonProperty;

public abstract class Wrapper {
	
	@JsonProperty("ok")
	protected boolean ok;
	@JsonProperty("tiempoRespuesta")
	protected String tiempoRespuesta;
	@JsonProperty("cantidadResultados")
	protected int cantidadResultados;
	@JsonProperty("url")
	protected String url;
	@JsonProperty("error")
	protected Error error;
	@JsonProperty("tipoMetodo")
	protected String tipoMetodo;
	
	@JsonProperty("data")
	protected boolean data;
	
	
	public Wrapper() {
		super();
	}
	public Wrapper(boolean ok, String tiempoRespuesta, int cantidadResultados, String url, Error error,
			String tipoMetodo) {
		super();
		this.ok = ok;
		this.tiempoRespuesta = tiempoRespuesta;
		this.cantidadResultados = cantidadResultados;
		this.url = url;
		this.error = error;
		this.tipoMetodo = tipoMetodo;
	}
	

	/**
	 * @return the ok
	 */
	public boolean isOk() {
		return ok;
	}
	/**
	 * @param ok the ok to set
	 */
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	/**
	 * @return the tiempoRespuesta
	 */
	public String getTiempoRespuesta() {
		return tiempoRespuesta;
	}
	/**
	 * @param tiempoRespuesta the tiempoRespuesta to set
	 */
	public void setTiempoRespuesta(String tiempoRespuesta) {
		this.tiempoRespuesta = tiempoRespuesta;
	}
	/**
	 * @return the cantidadResultados
	 */
	public int getCantidadResultados() {
		return cantidadResultados;
	}
	/**
	 * @param cantidadResultados the cantidadResultados to set
	 */
	public void setCantidadResultados(int cantidadResultados) {
		this.cantidadResultados = cantidadResultados;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the error
	 */
	public Error getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(Error error) {
		this.error = error;
	}
	/**
	 * @return the tipoMetodo
	 */
	public String getTipoMetodo() {
		return tipoMetodo;
	}
	/**
	 * @param tipoMetodo the tipoMetodo to set
	 */
	public void setTipoMetodo(String tipoMetodo) {
		this.tipoMetodo = tipoMetodo;
	}
	public boolean isData() {
		return data;
	}
	public void setData(boolean data) {
		this.data = data;
	}
	
	

}
