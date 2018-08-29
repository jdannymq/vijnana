package com.fwk.template;

import com.fwk.template.ITemplate;
//import java.io.File;
import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class TemplateVelocity
implements ITemplate
{
	private static final Log objLog = LogFactory.getLog(TemplateVelocity.class);
	Properties properties = null;

	public TemplateVelocity() {
		super();
	}

	public String getBodyByTemplate(String urlVm, Map<String, String> mapa, String nombrePlantilla)
	{
		String retBody = null;

		try
		{
			retBody = getBodyByTemplateJarWeb(mapa, nombrePlantilla, urlVm);
		}
		catch (Exception e) {
			
		}

		return retBody;
	}


	private String getBodyByTemplateJarWeb(Map<String, String> mapa, String nombrePlantilla, String rutaBase)
	{
		String nombreArchivo = nombrePlantilla.concat(".vm");
		
		String rutaTemplate = rutaBase;

		try
		{
			Properties properties = new Properties();

			properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
			properties.setProperty("file.resource.loader.path", rutaTemplate);
			properties.setProperty("file.resource.loader.cache", "false");
			properties.setProperty("file.resource.loader.modificationCheckInterval", "0");
			properties.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.Log4JLogChute");
			properties.setProperty("runtime.log.logsystem.log4j.logger", "VELOCITY");
			Velocity.init(properties);

			VelocityContext context = new VelocityContext();
			context.put("data", mapa);

			Template t = Velocity.getTemplate(nombreArchivo);

			StringWriter writer = new StringWriter();

			t.merge(context, writer);
			
			String cuerpoHtmlCorreo = writer.toString();
			cuerpoHtmlCorreo = cuerpoHtmlCorreo.replaceAll("ó", "&oacute;");
			cuerpoHtmlCorreo = cuerpoHtmlCorreo.replaceAll("á", "&aacute;");
			cuerpoHtmlCorreo = cuerpoHtmlCorreo.replaceAll("í", "&iacute;");
			cuerpoHtmlCorreo = cuerpoHtmlCorreo.replaceAll("é", "&eacute;");
			cuerpoHtmlCorreo = cuerpoHtmlCorreo.replaceAll("ú", "&uacute;");
			cuerpoHtmlCorreo = cuerpoHtmlCorreo.replaceAll("Ã³", "&oacute;");
			cuerpoHtmlCorreo = cuerpoHtmlCorreo.replaceAll("ñ", "&ntilde;");
			cuerpoHtmlCorreo = cuerpoHtmlCorreo.replaceAll("Ãº", "&ntilde;");

			
			return cuerpoHtmlCorreo;

		} catch (Exception ex) {
			ex.printStackTrace();
			objLog.error(ex.getMessage());
			
		}

		return null;
	}
}