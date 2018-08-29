//package vijnana.wsrest.client.impl;
//
//import java.text.SimpleDateFormat;
//
//import org.codehaus.jackson.map.DeserializationConfig;
//import org.codehaus.jackson.map.ObjectMapper;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
//import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
//
//import vijnana.respuesta.wrapper.Wrapper;
//import vijnana.wsrest.client.IClienteFilterWsRest;
//
//public class ClienteFilterWsRest implements IClienteFilterWsRest<Wrapper>{
//	
//	String usuario = "";
//	String seguridadAplicacion = "";
//	
//	public ClienteFilterWsRest() {
//		super();
//	}
//	
//	public ClienteFilterWsRest(String usuario, String seguridadAplicacion) {
//		super();
//		this.usuario = usuario;
//		this.seguridadAplicacion = seguridadAplicacion;
//	}
//
//	@SuppressWarnings("unchecked")
//	public <T> T postFilter(T content, Class<T> typeRequest, Class<T> typeResponse , String servidorProp, String urlMetodo) {
//
//		try { 
//			Client client = Client.create();
//			
//			if(seguridadAplicacion!=null && !seguridadAplicacion.equals("")){
//				client.addFilter(new HTTPBasicAuthFilter(usuario, seguridadAplicacion));
////				client.addFilter(new HTTPDigestAuthFilter(usuario, seguridadAplicacion));
//			}
//			
//			ClientResponse response=null;
//
//			WebResource webResource = client.resource(servidorProp+urlMetodo);
//			
//			
//			
//			response = webResource.type("application/json").post(ClientResponse.class, content);
//			
//			if (response.getStatus() >= 200 && response.getStatus() <= 299){
//				String responseString = response.getEntity(String.class);
//
//				try{
//					Object attrWrapper = obtenerJsonRespuesta(responseString, typeResponse); 
//					if( attrWrapper ==null){
//						return null;
//					}else if( attrWrapper instanceof vijnana.respuesta.wrapper.Error){
//						return null;
//					}else{
//						return (T) attrWrapper;
//					}
//				}catch(Exception exx){
//					System.out.println("Continuamos A1");
//				}
//				return  (T) response.getEntity(typeResponse);
//
//			}
//			if (!(response.getStatus() >= 200 && response.getStatus() <= 299)){
//				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//			}
//
//		} catch (Exception e) { 
//			e.printStackTrace(); 
//		}
//		return null;
//	}
//
//	@SuppressWarnings("unchecked")
//	public <T> T getFilter(String key, Class<T> typeResponse, String servidorProp, String urlMetodo) { 
//
//		Object objetoResponse = null;
//		try { 
//			Client client = Client.create();
//			ClientResponse response=null;
//
//			WebResource webResource = client.resource(servidorProp+urlMetodo+key);
//
//			response = webResource.type("application/json").get(ClientResponse.class);
//			if (response.getStatus() >= 200 && response.getStatus() <= 299){
//				String output = response.getEntity(String.class);
//			}
//			if (!(response.getStatus() >= 200 && response.getStatus() <= 299)){
//				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//			}
//
//		} catch (Exception e) { 
//			e.printStackTrace(); 
//		}
//		return (T)objetoResponse;
//	}
//
//	@SuppressWarnings("unchecked")
//	public <T> T obtenerJsonRespuesta(String responseString,  Class<T> typeResponse){
//		//		System.out.println(responseString);
//		Gson gson = new Gson();
//		String error = "";
//		JsonElement json = gson.fromJson(responseString.toString(), JsonElement.class);
//		
//		try{
//			if(json!=null){
//				if(json.getAsJsonObject().get("ok").getAsBoolean() &&  json.getAsJsonObject().get("data") != null){
//					if(json.getAsJsonObject().get("data") instanceof JsonElement){
//						JsonElement elementData = json.getAsJsonObject().get("data");
//						if(elementData.getAsJsonObject() != null){
//							return (T) gson.fromJson(elementData.getAsJsonObject(), typeResponse);
//
//						}
//					}
//				}else{
//					error =  json.getAsJsonObject().get("error").getAsString();
//					return (T) gson.fromJson(error, vijnana.respuesta.wrapper.Error.class);
//				}
//			}
//
//		}catch(Exception e){
//			
//			
//			//System.out.println(e);
//			System.out.println("Continuamos A");
//			try{
//				if(json.getAsJsonObject().get("ok").getAsBoolean() &&  json.getAsJsonObject().get("data") != null){
//					if(json.getAsJsonObject().get("data") instanceof JsonElement){
//						JsonElement elementData = json.getAsJsonObject().get("data");
//						if(elementData.getAsJsonArray() != null){
//							return (T) gson.fromJson(elementData.getAsJsonArray(), typeResponse);
//						}
//					}
//				}
//			}catch(Exception ex){
//				//				System.out.println(e);
//				System.out.println("Continuamos B");
//				ObjectMapper objectMapper = new ObjectMapper();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//				objectMapper.setDateFormat(sdf);
//				objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//				
////				return null;
//				
////				return  (T) response.getEntity(typeResponse);
//
//			}
//
//		}
//		
//		return null;
//	}
//
//
//
//	////////////////////////////////////////////////////////////////////////////////////////////////
//	////////////////////////////////////////////////////////////////////////////////////////////////
//	////////////////////////////////////////////////////////////////////////////////////////////////
//
//
//} 