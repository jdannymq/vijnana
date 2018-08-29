package vijnana.wsrest.client;

public interface IClienteFilterWsRest<T>{
	
	public <T> T postFilter(T content, Class<T> typeRequest, Class<T> typeResponse, String servidorProp , String urlMetodo) throws Exception;
	public <T> T getFilter(String key, Class<T> typeResponse, String servidorProp, String urlMetodo);
	
}
