package vijnana.wsrest.client.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesCliente {
	
	public PropertiesCliente(){
		super();
	}

	private static Properties properties;

	public void generarPropertiesLocal(){
		Properties metProp = new Properties();
		InputStream is = null;
		String nombreArch = "vijnana.wsrest.client.properties";

		is = getClass().getClassLoader().getResourceAsStream(nombreArch);

		try {
			metProp.load(is);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			metProp = new Properties();
		}
		properties = metProp;
	}


	public Properties obtenerPropertiesLocal(){

		if(properties == null){  

			generarPropertiesLocal();  
		}  

		return properties; 
	}

	//vijnana.rest.client.properties
	public String getWProduccion(String ambiente) {
		Properties metProp = obtenerPropertiesLocal();
		String wserver  = ""; 
		if(ambiente.toLowerCase().equalsIgnoreCase("dev")){
			wserver = metProp.getProperty("servidor.desarrollo");
		}
		if(ambiente.toLowerCase().equalsIgnoreCase("qa")){
			wserver = metProp.getProperty("servidor.certificacion");
		}
		if(ambiente.toLowerCase().equalsIgnoreCase("prod")){
			wserver = metProp.getProperty("servidor.produccion");
		}
		return wserver;
	}
	

}
