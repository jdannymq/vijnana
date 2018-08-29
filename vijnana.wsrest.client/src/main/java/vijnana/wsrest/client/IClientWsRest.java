package vijnana.wsrest.client;

import com.sun.jersey.api.client.filter.ClientFilter;

import vijnana.wsrest.client.exception.VijnanaClientException;

public interface IClientWsRest<T>{
	
	public <T> void post(T content, Class<T> typeRequest, String servidorProp, String urlMetodo) throws Exception;
	public <T> T post(T content, Class<T> typeRequest, Class<T> typeResponse, String servidorProp , String urlMetodo) throws VijnanaClientException, Exception;
	public <T> T postWithFilter(T content, Class<T> typeRequest, Class<T> typeResponse , String servidorProp, String urlMetodo, ClientFilter clientFilterAgentAuth, 
			int connectTimeout, int readTimeout) throws VijnanaClientException, Exception;
	public <T> T get(String key, Class<T> typeResponse, String servidorProp, String urlMetodo);
	
}
