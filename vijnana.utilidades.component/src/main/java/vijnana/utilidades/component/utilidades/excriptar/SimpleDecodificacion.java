package vijnana.utilidades.component.utilidades.excriptar;

import java.nio.charset.StandardCharsets;

import org.apache.commons.lang.StringEscapeUtils;
import org.codehaus.jackson.io.JsonStringEncoder;

public class SimpleDecodificacion {
	
	public static String getEscapeTexto(String input) {
		JsonStringEncoder jse = JsonStringEncoder.getInstance();
		String escapado =  new String(jse.quoteAsString(input));
		return escapado;
	}
	
	public static String getUnescapeTexto(String input) {
		input = StringEscapeUtils.unescapeJava(input);
		return input;
	}
	
	public static String getBase64(String input) {
		java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
	        String encriptado = encoder.encodeToString(input.getBytes(StandardCharsets.UTF_8) );        
	        return encriptado;
	    }
	
	public static String descifrarBase64(String input){
		java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        
		byte[] decodedByteArray = decoder.decode(input);
 
        String descifrado = new String(decodedByteArray);        
        
        return descifrado;
    }
}
