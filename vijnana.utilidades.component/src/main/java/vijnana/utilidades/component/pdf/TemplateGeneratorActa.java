package vijnana.utilidades.component.pdf;


import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemplateGeneratorActa {
	
	 private String directory;
	    private String plantilla;
	    
//	    private Cartola cabecera;
	    
	    private String htmlDescNegocio = "";
		private String htmlComFinanciero = "";
		private String htmlRationale = ""; 
		
		private static final Logger LOGGER = LoggerFactory.getLogger(TemplateGeneratorActa.class);

	    public TemplateGeneratorActa(String dir, String htmlDescNegocioTmp, String htmlComFinancieroTmp, String htmlRationaleTmp) {
	        
	    	
	        
	        this.htmlDescNegocio = htmlDescNegocioTmp;
	        this.htmlComFinanciero = htmlComFinancieroTmp;
	        this.htmlRationale = htmlRationaleTmp;
	        
	        this.directory = dir.substring(0, dir.lastIndexOf("/"));
	        this.plantilla = dir.substring(dir.lastIndexOf("/")+1, dir.length());
	    }
		
	    
	    public String generateTemplate() {
	    	 
	        String result = "";

//	        Configuration cfg = new Configuration();
//	        try {

	            String directoryTemplate = directory;
	            String plantillaCorreo = plantilla;
	           
//	            ((Object) cfg).setDirectoryForTemplateLoading(new File(directoryTemplate));
//	            Template template = cfg.getTemplate(plantillaCorreo);
	           

	            Map<String, Object> data = new HashMap<String, Object>();
	            
	            //incorporacion del logo en la cartola
	    		String generateLogo = "";
//	    		try {
	    			byte[] encode = null;

	    			generateLogo = new String(encode);
	    			//System.out.println(generateLogo);
//	    		} catch (IOException e) {
//	    			LOGGER.error(e.getLocalizedMessage());
//	    		}
	    		data.put("logo", generateLogo);
	    		
//	            data.put("codProp", cabecera.getCabecera().getCodPropuesta());
//	            data.put("fecProp", cabecera.getCabecera().getFecPropuesta());

//	            data.put("nomCliente", cabecera.getCabecera().getNomCliente());
//	            data.put("rutCliente", cabecera.getCabecera().getRutCliente());
//	            data.put("actCliente", cabecera.getCabecera().getNomActividad());
//	            data.put("gruCliente", cabecera.getCabecera().getCargoEmpresarial());
//	            data.put("sucCliente", cabecera.getCabecera().getNomSucursal());
//	            data.put("ejeCliente", cabecera.getCabecera().getNomEjecutivo());
//	            data.put("supCliente", cabecera.getCabecera().getNomSupervisor());
//	            data.put("areaCliente", cabecera.getCabecera().getNomArea());
//	            
//	            data.put("arrAccion", regAcc);
//
//	            data.put("arrIdProp", regIdentCredOpeProp); //"    CAP.TRABAJO M/N"
//	            data.put("arrIdVig", regIdentCredOpeVig);
//	            
//	            data.put("arrIdRiesgo", regIdentCredRiesgo);
//	            data.put("arrIdTotal", regIdentCredTotales);
//	            data.put("arrIdValor", regIdentCredValores);
//
//	            data.put("arrObProp", regObCredOpeProp);
//	            data.put("arrObVig", regObCredOpeVig);
//	            data.put("arrObRiesgo", regObCredRiesgo);
//	            
//	            data.put("arrDeuda", regDeuda);
//
//	            data.put("arrArNeg", regArNeg);
//	            data.put("arrArNegEst", regArNegEst);
//
//	            data.put("arrDetGar", regDetGarant);
//	            data.put("arrLinProd", regLinProd);
//	            data.put("arrLinProv", regLinProv);
//	            data.put("arrPool", regPool);
//	            data.put("arrObs", regObs);
//	            
//	            data.put("arrObs", regObs);
	            
	            data.put("htmlDescNegocio", htmlDescNegocio);
	            data.put("htmlComFinanciero", htmlComFinanciero);
	            data.put("htmlRationale", htmlRationale);
	            
	            Writer fileString = new StringWriter();
//	            template.process(data, fileString);
	            fileString.toString();

	            result = fileString.toString();
//	            result.replace("XXXX", "&nbsp;&nbsp;&nbsp;&nbsp;");
//	            System.out.println(result);
	            //LOGGER.debug(result);
	            
//	        } catch (IOException e) {
//	            LOGGER.error(e.getLocalizedMessage());
//	        } 
//	        catch (TemplateException ex) {
//	            LOGGER.error(ex.getLocalizedMessage());
//	        }
	        return result;
	    }
	    
		
}
