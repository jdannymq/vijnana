package vijnana.utilidades.component.apiproperties;

import vijnana.utilidades.component.exception.VijnanaUtilidadesException;


public class AppProperties {
	
	public AppProperties(){
		super();
	}
	
	/*Aqui deben apuntar Todas la Apis*/
	public ServerProperties obtenerAppProperties()throws Exception{
		ServerProperties metAppProperties = null;
		
		metAppProperties = new ServerProperties();
		
		return metAppProperties;
	}
	
	public String getLineaAppProperties(String nombreAplicacionProperties) throws VijnanaUtilidadesException{
		ServerProperties metProp;
		String lineaAppProperties = "";
		try {
			metProp = obtenerAppProperties();
			lineaAppProperties = metProp.getProperty(nombreAplicacionProperties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new  VijnanaUtilidadesException(e);
		}
		
		return lineaAppProperties;
	}
	
}
