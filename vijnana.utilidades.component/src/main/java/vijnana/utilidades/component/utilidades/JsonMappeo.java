package vijnana.utilidades.component.utilidades;

//import java.io.IOException;
//import java.text.SimpleDateFormat;
//
//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.map.DeserializationConfig;
//import org.codehaus.jackson.map.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vijnana.utilidades.component.exception.VijnanaUtilidadesException;

public class JsonMappeo {

	public static String convertirObjectToJson(Object objeto)
	{
		String retorno = null;
		try
		{
			retorno = doConvertirObjectToJson(objeto); 
		}
		catch (Exception ex)
		{

			
		}
		return retorno;
	}

	public static String doConvertirObjectToJson(Object objeto) throws VijnanaUtilidadesException
	{
		try
		{
			return new ObjectMapper().writeValueAsString(objeto);
		}
		catch (Exception ex)
		{

			throw new VijnanaUtilidadesException(ex);
		}
	}

}
