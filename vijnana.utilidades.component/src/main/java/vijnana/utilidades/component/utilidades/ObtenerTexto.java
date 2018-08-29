package vijnana.utilidades.component.utilidades;

import java.util.Base64;

public class ObtenerTexto {

	public ObtenerTexto(){

	}

	public static String obtenerTextoBySplit(String texto, String split, int indice){  //texto /  ":" / 0
		return texto.split(split)[indice];
	}

	public static String[] obtenerTextoBySplit(String texto, String split){  //texto /  ":" / 0

		if(texto.startsWith(split)){
			texto = texto.substring(split.length(),texto.length());
		}

		String[] textos = texto.split(split);

		String [] retorno = new String[textos.length];

		int cont = 0;
		for(int i=0; i<textos.length; i++){
			if(!textos.equals("")){
				retorno[cont] = textos[i];
				cont++;
			}

		}

		return retorno;
	}

	public static String[] obtenerTextoBySplitConExcepciones(String texto, String split, String [] excepcion){  //texto /  ":" / 0

		if(texto.startsWith(split)){
			texto = texto.substring(split.length(),texto.length());
		}

		String[] textos = texto.split(split);

		String [] retornoConExcepciones = new String[textos.length];
		
		int cont = 0;
		int excepcionCont = 0;
		
		for(int i=0; i<textos.length; i++){
			for(int j=0; j<excepcion.length; j++){
				if(!textos[i].equals(excepcion[j]) && !textos.equals("")){
					retornoConExcepciones[cont] = textos[i];
					
					cont++;
				}else{
					if(textos[i].equals(excepcion[j])){
						excepcionCont++;
					}
					
				}
			}
		}
		
		int largoRetorno = retornoConExcepciones.length - excepcionCont;
		
		String [] retorno = new String[largoRetorno];
		
		cont = 0;
		 
		for(int i=0; i<largoRetorno; i++){
			
			retorno[cont] = retornoConExcepciones[i];
			
			cont++;
		}
				
		return retorno;
	}
	
	public static String [] obtenerArrayBasicAuthorization(String authorizacionHeader){
//		String codificado = httpServletRequest.getHeader("authorization");
		String dataAuthorization = authorizacionHeader.substring(authorizacionHeader.indexOf(" ") + 1);
		
		byte[] bytesAuthorization = Base64.getDecoder().decode(dataAuthorization);
		
		String basicAuthorization = new String(bytesAuthorization);
		
		return obtenerTextoBySplit(basicAuthorization, ":");
//		[0]: usuario
//		[1]: contrasenha
	}
	
//	public static String [] generarArrayBasicAuthorization(String ...authorizacionHeader){
//
//		return authorizacionHeader;
////		[0]: usuario
////		[1]: contrasenha
//	}
	
	public static String limpiarEspacion(String cadena){

		return cadena.trim();
//		[0]: usuario
//		[1]: contrasenha
	}
	
}
