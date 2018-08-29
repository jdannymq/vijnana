package vijnana.utilidades.component.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class AppDate {
	//    public static String strFormatoFecha = "dd/MM/yyyy HH:mm:ss";



	/*Generar con todas las convinaciones posibles*/
	public static String strFormatoFechaDD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
	public static String strFormatoFechaDD_MM_YYYY = "dd-MM-yyyy";
	public static String strFormatoFechaHH_MM_SS =  "HH:mm:ss";
	public static String strFormatoFechaYYYY_MM_DD =  "yyyy-MM-dd";
	public static String strFormatoFechaYYYY_MM_ddTHH_MM_SSZ =  "yyyy-MM-dd'T'HH:mm:ss'Z'";


	public static synchronized Date agregarMinutos(Date fecha, int minutos) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		//        calendar.add(12, minutos);
		calendar.add(Calendar.MINUTE, 20);
		return calendar.getTime();
	}

	public static synchronized Date agregarHoras(Date fecha, int horas) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(10, horas);
		return calendar.getTime();
	}

	public static synchronized Date agregarDias(Date fecha, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(6, dias);
		return calendar.getTime();
	}

	public static synchronized Date agregarSemanas(Date fecha, int horas) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(6, horas * 7);
		return calendar.getTime();
	}

	public static int obtenerCantidadDiasEntreFechas(Date fechaMayor, Date fechaMenor){
		long diferenciaEn_ms = fechaMayor.getTime() - fechaMenor.getTime();
		long dias = diferenciaEn_ms / 86400000;
		return (int)(dias + 1);
	}

	public static int obtenerCantidadNochesEntreFechas(Date fechaMayor, Date fechaMenor) {
		long diferenciaEn_ms = fechaMayor.getTime() - fechaMenor.getTime();
		long dias = diferenciaEn_ms / 86400000;
		return (int)dias;
	}

	public static String obtenerDiaDeLaSemana(Date fecha) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(fecha);
		String dia = "";
		switch (cal.get(7)) {
		case 1: {
			dia = "Domingo";
			break;
		}
		case 2: {
			dia = "Lunes";
			break;
		}
		case 3: {
			dia = "Martes";
			break;
		}
		case 4: {
			dia = "Mi\u00e9rcoles";
			break;
		}
		case 5: {
			dia = "Jueves";
			break;
		}
		case 6: {
			dia = "Viernes";
			break;
		}
		case 7: {
			dia = "S\u00e1bado";
		}
		}
		return dia;
	}
	//obtenerFormatoFecha
	public static synchronized String obtenerFechaEnFormato(Date fecha, TipoFormatoFecha tipo) {

		SimpleDateFormat formatoFecha = new SimpleDateFormat(strFormatoFechaDD_MM_YYYY);
		SimpleDateFormat formatoHora = new SimpleDateFormat(strFormatoFechaHH_MM_SS);
		SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		SimpleDateFormat formatoFecha_YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatoFecha_YYYY_MM_DDTHHmmss = new SimpleDateFormat(strFormatoFechaYYYY_MM_ddTHH_MM_SSZ);
		if (null == fecha) {
			return "";
		}
		if (tipo.equals((Object)TipoFormatoFecha.DD_MM_YYYY)) {
			return formatoFecha.format(fecha);
		}
		if (tipo.equals((Object)TipoFormatoFecha.HH_MM_SS)) {
			return formatoHora.format(fecha);
		}
		if (tipo.equals((Object)TipoFormatoFecha.DD_MM_YYYY_HH_MM_SS)) {
			return formatoFechaHora.format(fecha);
		}
		if (tipo.equals((Object)TipoFormatoFecha.YYYY_MM_DD)) {
			return formatoFecha_YYYY_MM_DD.format(fecha);
		}
		if (tipo.equals((Object)TipoFormatoFecha.YYYY_MM_ddTHH_MM_SSZ)) {
			return formatoFecha_YYYY_MM_DDTHHmmss.format(fecha);
		}
		return "";
	}

	public static Date obtenerFechaHoraActual(String Zona, String metStrFormatoFechaDD_MM_YYYY_HH_MM_SS) {
		try {
			return AppDate.convertirFechaZonaHoraria(new Date(), TimeZone.getTimeZone(Zona), metStrFormatoFechaDD_MM_YYYY_HH_MM_SS);
		}
		catch (ParseException ex) {
			return null;
		}
	}

	public static Date convertirFechaZonaHoraria(Date fecha, TimeZone timeZone, String strFormatoFechaDD_MM_YYYY_HH_MM_SS) throws ParseException {
		SimpleDateFormat conversorZona = new SimpleDateFormat(strFormatoFechaDD_MM_YYYY_HH_MM_SS);
		conversorZona.setTimeZone(timeZone);
		SimpleDateFormat conversorLocal = new SimpleDateFormat(strFormatoFechaDD_MM_YYYY_HH_MM_SS);
		Date fechaConvertida = conversorLocal.parse(conversorZona.format(fecha));
		return fechaConvertida;
	}

	public static String generarTiempoDuracion(long segundos, int nano){

		return segundos+","+nano;
	}

	public static Date convertirStrFormatDD_MM_YYYYTHH_MM_SSZToDate(String sFecha) {
		//    	SimpleDateFormat formatInicial = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		java.util.Date fechaRetorno = null;

		if(isValidDate(sFecha, strFormatoFechaYYYY_MM_ddTHH_MM_SSZ)){
			try{
				long miliHoy = 0;

				int ano1 = Integer.parseInt(sFecha.substring(0, 4));
				int mes1 = Integer.parseInt(sFecha.substring(5, 7));
				int dia1 = Integer.parseInt(sFecha.substring(8, 10));
				int hora1 = Integer.parseInt(sFecha.substring(8, 10));
				int minuto1 = Integer.parseInt(sFecha.substring(8, 10));
				int seg1 = Integer.parseInt(sFecha.substring(8, 10));

				GregorianCalendar c = new GregorianCalendar(ano1, mes1-1, dia1, hora1, minuto1, seg1);

				miliHoy = c.getTime().getTime();

				fechaRetorno = new java.util.Date(miliHoy);
			}catch(Exception e){
				fechaRetorno = new java.util.Date();
			}
		}else{
			fechaRetorno = new java.util.Date();
		}

		return fechaRetorno;
	}

	public static boolean isValidDate(String value, String strFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
		try{
			sdf.setLenient(false);
			sdf.parse(value);
			return true;
		}
		catch(ParseException e){
			return false;
		}
	}

}