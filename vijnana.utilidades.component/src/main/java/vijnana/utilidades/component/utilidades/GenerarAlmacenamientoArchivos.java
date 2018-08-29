package vijnana.utilidades.component.utilidades;


import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import vijnana.utilidades.component.exception.VijnanaUtilidadesException;

public class GenerarAlmacenamientoArchivos {
	
//	private static final String EXITO_ARCHIVO_XML = "EXITO CREACION";
	private String extensionXML = ".xml";
	
	public String almacenarObjectXMLFile(Object obj, String nombreCarpetaAplicacion,  String nombreArchivoXml)  throws VijnanaUtilidadesException{

		String direccionNombreArchivo = "";
		
		try {
			
			nombreCarpetaAplicacion = nombreCarpetaAplicacion+"/";
			
			Date fechaAhora = new Date();
			
			String nombreCarpetaAnho = obtenerCarpetaAnho(fechaAhora);
			
			String nombreCarpetaMes  = obtenerCarpetaMesDelanho(fechaAhora);
			
			String nombreCarpetaDia = obtenerCarpetaDiaDelMes(fechaAhora);
			
			String nombreCarpetaHora = obtenerCarpetaHoradelDiaDelMes(fechaAhora);
			
			String fileFolderEscritura = System.getProperty("catalina.base") + "/temp/"+nombreCarpetaAplicacion+nombreCarpetaAnho+nombreCarpetaMes+nombreCarpetaDia 
					+nombreCarpetaHora;
			
			String filePathFinal = fileFolderEscritura + nombreArchivoXml + extensionXML;

			File folderAplicacion = new File(System.getProperty("catalina.base") + "/temp/"+nombreCarpetaAplicacion);
			
			File folderAplicacionAnho = new File(System.getProperty("catalina.base") + "/temp/"+nombreCarpetaAplicacion + nombreCarpetaAnho);
			
			File folderAplicacionAnhoMes = new File(System.getProperty("catalina.base") + "/temp/"+nombreCarpetaAplicacion + nombreCarpetaAnho + nombreCarpetaMes);
			
			File folderAplicacionAnhoMesDia = new File(System.getProperty("catalina.base") + "/temp/"+nombreCarpetaAplicacion+nombreCarpetaAnho+nombreCarpetaMes+nombreCarpetaDia);
			
			File folderAplicacionAnhoMesDiaHora = new File(fileFolderEscritura);

			verificarCarpetas(folderAplicacion, folderAplicacionAnho, folderAplicacionAnhoMes, folderAplicacionAnhoMesDia, folderAplicacionAnhoMesDiaHora);
			
			File file = new File(filePathFinal);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
			
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			jaxbMarshaller.marshal(obj, file);
									
			direccionNombreArchivo = filePathFinal;

		}catch(NoClassDefFoundError ex){
			throw new  VijnanaUtilidadesException(ex);
		} catch (Exception e) {
			throw new  VijnanaUtilidadesException(e);
		}
		return direccionNombreArchivo;
	}
	
	
	public <T> T almacenarObjectFile(T content, String carpetaNombreCarpetaProyectoNombreArchivo, byte fileContent[]) {
		
//		String carpetaNombreCarpetaProyectoNombreArchivo = "";
		
		try {
//			carpetaNombreCarpetaProyectoNombreArchivo = generarNombreCarpetaProyectoNombreArchivo(nombreCarpetaAplicacion,  nombreArchivo);

			FileOutputStream fos = new FileOutputStream(carpetaNombreCarpetaProyectoNombreArchivo);

			fos.write(fileContent);
			
			fos.flush();
			
			fos.close();
			
		}catch(NoClassDefFoundError ex){
		
		} catch (Exception e) {
		
		}
		return content;
	}
	
	public String generarNombreCarpetaProyectoNombreArchivo(String nombreCarpetaProyectoAplicacion,  String nombreArchivo){
		
		nombreCarpetaProyectoAplicacion = nombreCarpetaProyectoAplicacion+"/";
		Date fechaAhora = new Date();
		String nombreCarpetaAnho = obtenerCarpetaAnho(fechaAhora);
		String nombreCarpetaMes  = obtenerCarpetaMesDelanho(fechaAhora);
		String nombreCarpetaDia = obtenerCarpetaDiaDelMes(fechaAhora);
		String nombreCarpetaHora = obtenerCarpetaHoradelDiaDelMes(fechaAhora);
		//Hacer hora-minuto-segundo.. para no producir repetidos
//		String fileName = upFile.getFileName();
		
		String fileFolderEscritura = System.getProperty("catalina.base") + "/temp/"+nombreCarpetaProyectoAplicacion+nombreCarpetaAnho+nombreCarpetaMes+nombreCarpetaDia
				+nombreCarpetaHora;
//		String filePathFinal = fileFolderEscritura + nombreArchivo;

		File folderAplicacion = new File(System.getProperty("catalina.base") + "/temp/"+nombreCarpetaProyectoAplicacion);
		File folderAplicacionAnho = new File(System.getProperty("catalina.base") + "/temp/"+nombreCarpetaProyectoAplicacion + nombreCarpetaAnho);
		File folderAplicacionAnhoMes = new File(System.getProperty("catalina.base") + "/temp/"+nombreCarpetaProyectoAplicacion + nombreCarpetaAnho + nombreCarpetaMes);
		File folderAplicacionAnhoMesDia = new File(System.getProperty("catalina.base") + "/temp/"+nombreCarpetaProyectoAplicacion + nombreCarpetaAnho + nombreCarpetaMes+nombreCarpetaDia);
		File folderAplicacionAnhoMesDiaHora = new File(fileFolderEscritura);

		verificarCarpetas(folderAplicacion, folderAplicacionAnho, folderAplicacionAnhoMes, folderAplicacionAnhoMesDia, folderAplicacionAnhoMesDiaHora);
		
		return fileFolderEscritura+nombreArchivo;
	}
	
	public String obtenerCarpetaAnho(Date fechaAhora) {

		SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");

		String formatFechaEntrada = formatoEntrada.format(fechaAhora).toString();

		int anhoCarpeta = Integer.parseInt(formatFechaEntrada.substring(6, 10));

		String nombreCarpetaAnho= anhoCarpeta+"/"; 

		return nombreCarpetaAnho;
	}

	public String obtenerCarpetaMesDelanho(Date fechaAhora) {

		SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
		String formatFechaEntrada = formatoEntrada.format(fechaAhora).toString();
		int mesCarpeta = Integer.parseInt(formatFechaEntrada.substring(3, 5));

		String nombreCarpetaMes=""; 
		if(mesCarpeta==1){
			nombreCarpetaMes = mesCarpeta+"-Enero/";
		}
		else if(mesCarpeta==2){
			nombreCarpetaMes = mesCarpeta+"-Febrero/";
		}
		else if(mesCarpeta==3){
			nombreCarpetaMes = mesCarpeta+"-Marzo/";
		}
		else if(mesCarpeta==4){
			nombreCarpetaMes = mesCarpeta+"-Abril/";
		}
		else if(mesCarpeta==5){
			nombreCarpetaMes = mesCarpeta+"-Mayo/";
		}
		else if(mesCarpeta==6){
			nombreCarpetaMes = mesCarpeta+"-Junio/";
		}
		else if(mesCarpeta==7){
			nombreCarpetaMes = mesCarpeta+"-Julio/";
		}
		else if(mesCarpeta==8){
			nombreCarpetaMes = mesCarpeta+"-Agosto/";
		}
		else if(mesCarpeta==9){
			nombreCarpetaMes = mesCarpeta+"-Septiembre/";
		}
		else if(mesCarpeta==10){
			nombreCarpetaMes = mesCarpeta+"-Octubre/";
		}
		else if(mesCarpeta==11){
			nombreCarpetaMes = mesCarpeta+"-Noviembre/";
		}
		else if(mesCarpeta==12){
			nombreCarpetaMes = mesCarpeta+"-Diciembre/";
		}
		else {
			nombreCarpetaMes = "temp";
		}
		return nombreCarpetaMes;
	}

	public String obtenerCarpetaDiaDelMes(Date fechaAhora) {

		SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
		String formatFechaEntrada = formatoEntrada.format(fechaAhora).toString();
		int diaCarpeta = Integer.parseInt(formatFechaEntrada.substring(0, 2));

		String nombreCarpetaDia=""; 

		nombreCarpetaDia = diaCarpeta+"/";

		return nombreCarpetaDia;
	}
	
	public String obtenerCarpetaHoradelDiaDelMes(Date fechaAhora) {

		SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
		String formatFechaEntrada = formatoEntrada.format(fechaAhora).toString();
		int horaCarpeta = Integer.parseInt(formatFechaEntrada.substring(11, 13));

		String nombreCarpetaHora=""; 

		nombreCarpetaHora = horaCarpeta+"-Hora/";

		return nombreCarpetaHora;
	}
	
	public void verificarCarpetas(File folderAplicacion, File folderAplicacionAnho, File folderAplicacionAnhoMes, File folderAplicacionAnhoMesDia, File folderAplicacionAnhoMesDiaHora){
		if(!folderAplicacion.exists()){
			folderAplicacion.mkdir();
		}
		if(!folderAplicacionAnho.exists()){
			folderAplicacionAnho.mkdir();
		}
		if(!folderAplicacionAnhoMes.exists()){
			folderAplicacionAnhoMes.mkdir();
		}
		if(!folderAplicacionAnhoMesDia.exists()){
			folderAplicacionAnhoMesDia.mkdir();
		}
		if(!folderAplicacionAnhoMesDiaHora.exists()){
			folderAplicacionAnhoMesDiaHora.mkdir();
		}
	}

}
