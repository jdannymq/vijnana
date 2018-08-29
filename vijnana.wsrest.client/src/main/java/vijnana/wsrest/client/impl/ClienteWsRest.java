package vijnana.wsrest.client.impl;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import vijnana.respuesta.wrapper.response.Wrapper;
import vijnana.wsrest.client.IClientWsRest;
import vijnana.wsrest.client.exception.VijnanaClientException;

public class ClienteWsRest implements IClientWsRest<Wrapper>{
	

	public ClienteWsRest() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public <T> void post(T content, Class<T> typeRequest, String servidorProp, String urlMetodo) throws Exception{
		try { 
			Client client = Client.create();
			
			ClientResponse response=null;

			WebResource webResource = client.resource(servidorProp+urlMetodo);
			
			response = webResource.type("application/json").post(ClientResponse.class, content);
			
			if (response.getStatus() >= 200 && response.getStatus() <= 299){
				String responseString = response.getEntity(String.class);

				try{
					Object attrWrapper = obtenerJsonRespuesta(responseString, Object.class); 
					if( attrWrapper ==null){
					
					}else if( attrWrapper instanceof vijnana.respuesta.wrapper.response.Error){
						throw new VijnanaClientException(((vijnana.respuesta.wrapper.response.Error) attrWrapper).getMensaje());
					}else{
					
					}
				}catch(Exception exx){
					throw new Exception(exx.getMessage());
				}

			}
			if (!(response.getStatus() >= 200 && response.getStatus() <= 299)){
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

		} catch (Exception e) { 
			e.printStackTrace(); 
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T post(T content, Class<T> typeRequest, Class<T> typeResponse , String servidorProp, String urlMetodo) throws VijnanaClientException, Exception{

		try { 
			Client client = Client.create();
			
			ClientResponse response=null;

			WebResource webResource = client.resource(servidorProp+urlMetodo);
			
			response = webResource.type("application/json").post(ClientResponse.class, content);
			
			if (response.getStatus() >= 200 && response.getStatus() <= 299){
				String responseString = response.getEntity(String.class);

				try{
					Object attrWrapper = obtenerJsonRespuesta(responseString, typeResponse); 
					if( attrWrapper ==null){
						return null;
					}else if( attrWrapper instanceof vijnana.respuesta.wrapper.response.Error){
						throw new VijnanaClientException(((vijnana.respuesta.wrapper.response.Error) attrWrapper).getMensaje());
					}else{
						return (T) attrWrapper;
					}
				}catch(Exception exx){
					System.out.println("Continuamos A1");
				}
				return  (T) response.getEntity(typeResponse);

			}
			if (!(response.getStatus() >= 200 && response.getStatus() <= 299)){
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T postWithFilter(T content, Class<T> typeRequest, Class<T> typeResponse , String servidorProp, String urlMetodo, ClientFilter clientFilterAgentAuth, 
			int connectTimeout, int readTimeout) throws VijnanaClientException{

		try { 
			Client client = Client.create();
			
			if(connectTimeout>0){
				client.setConnectTimeout(connectTimeout);
			}
			
			if(readTimeout>0){
				client.setReadTimeout(readTimeout);
			}
			
			if(clientFilterAgentAuth!=null){
				client.addFilter(clientFilterAgentAuth);
			}
			
			ClientResponse clientResponse=null;
			
			WebResource webResource = client.resource(servidorProp+urlMetodo);
			
			clientResponse = webResource.type("application/json").post(ClientResponse.class, content);
			
			if (clientResponse.getStatus() >= 200 && clientResponse.getStatus() <= 299){
				String responseString = clientResponse.getEntity(String.class);

				try{
					Object attrWrapper = obtenerJsonRespuesta(responseString, typeResponse); 
					if( attrWrapper ==null){
						return null;
					}else if( attrWrapper instanceof vijnana.respuesta.wrapper.response.Error){
//						throw new VijnanaClientException(((vijnana.respuesta.wrapper.Error) attrWrapper).getMensaje());
						return null;
					}else{
						return (T) attrWrapper;
					}
				}catch(Exception exx){
					System.out.println("Continuamos Entity");
				}
				return  (T) clientResponse.getEntity(typeResponse);

			}
			if (!(clientResponse.getStatus() >= 200 && clientResponse.getStatus() <= 299)){
				throw new RuntimeException("Failed : HTTP error code : " + clientResponse.getStatus());
			}

		} catch (Exception e) { 
			throw new VijnanaClientException(e); 
		}
		return null;
	}
	

	@SuppressWarnings("unchecked")
	public <T> T get(String key, Class<T> typeResponse, String servidorProp, String urlMetodo) { 

		Object objetoResponse = null;
		try { 
			Client client = Client.create();
			ClientResponse response=null;

			WebResource webResource = client.resource(servidorProp+urlMetodo+key);

			response = webResource.type("application/json").get(ClientResponse.class);
			if (response.getStatus() >= 200 && response.getStatus() <= 299){
				String output = response.getEntity(String.class);
			}
			if (!(response.getStatus() >= 200 && response.getStatus() <= 299)){
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		return (T)objetoResponse;
	}

	@SuppressWarnings("unchecked")
	public <T> T obtenerJsonRespuesta(String responseString,  Class<T> typeResponse){
		//		System.out.println(responseString);
		Gson gson = new Gson();
		String error = "";
		JsonElement json = gson.fromJson(responseString.toString(), JsonElement.class);
		
		try{
			if(json!=null){
				if(json.getAsJsonObject().get("ok")!=null && json.getAsJsonObject().get("ok").getAsBoolean()){
					if(json.getAsJsonObject().get("data") != null && json.getAsJsonObject().get("data") instanceof JsonElement){
						JsonElement elementData = json.getAsJsonObject().get("data");
						if(elementData.getAsJsonObject() != null){
							return (T) gson.fromJson(elementData.getAsJsonObject(), typeResponse);
						}
					}
				}else{
					JsonElement elementError =  json.getAsJsonObject().get("error");
					return (T) gson.fromJson(elementError.getAsJsonObject(), vijnana.respuesta.wrapper.response.Error.class);
				}
			}

		}catch(Exception e){
			
			
			//System.out.println(e);
			System.out.println("Continuamos A");
			try{
				if(json.getAsJsonObject().get("ok")!=null && json.getAsJsonObject().get("ok").getAsBoolean()){
					if(json.getAsJsonObject().get("data") != null && json.getAsJsonObject().get("data") instanceof JsonElement){
						JsonElement elementData = json.getAsJsonObject().get("data");
						if(elementData.getAsJsonArray() != null){
							return (T) gson.fromJson(elementData.getAsJsonArray(), typeResponse);
						}
					}
				}
			}catch(Exception ex){
				//				System.out.println(e);
				System.out.println("Continuamos B");
				ObjectMapper objectMapper = new ObjectMapper();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
				objectMapper.setDateFormat(sdf);
				objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
				
//				return null;
				
//				return  (T) response.getEntity(typeResponse);

			}

		}
		
		return null;
	}

	public ClientFilter setHTTPBasicAuthFilter(String agentUser, String agentSecret){
		
		ClientFilter agentAuth = new HTTPBasicAuthFilter(agentUser, agentSecret);
		
		return agentAuth;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////


} 