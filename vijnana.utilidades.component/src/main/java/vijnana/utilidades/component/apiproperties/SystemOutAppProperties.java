package vijnana.utilidades.component.apiproperties;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public  class SystemOutAppProperties {

	ObjectMapper objectMapper;
	
	SimpleDateFormat sdf;
	
	public <T> SystemOutAppProperties(T content, String properties){
		escrbirCatalina(content, properties);
	}

	public <T> void escrbirCatalina(T content, String properties){
		boolean escribir = false;
		if(objectMapper==null){
			objectMapper = new ObjectMapper();
			
			sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			
			objectMapper.setDateFormat(sdf);
			
			objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		}

		try {
			String request = null;
			escribir = Boolean.parseBoolean(properties);
			if(escribir){
				request = objectMapper.writeValueAsString(content);

				request = request.replace("null", "\"\"");

				System.out.println(request);
			}

		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
