package vijnana.utilidades.component.utilidades;

import java.sql.Timestamp;
import java.util.Date;

public class DateMapper {
	/*************Las Capas de Negocios El Parseo de Fechas  ***************************/
	public static java.util.Date DateSqlToDateUtil(java.sql.Date dateSql){

		java.util.Date dateUtil=new Date();
		if(dateSql==null){
			return new Date();
		}
		else{
			dateUtil = new java.util.Date(dateSql.getTime());
		}

		return dateUtil;
	}


	public static java.sql.Date DateUtilToDateSql(java.util.Date dateUtil){

		java.sql.Date dateSql=new java.sql.Date(0);
		if(dateUtil==null){
			return dateSql;
		}
		else{
			dateSql = new java.sql.Date(dateUtil.getTime());
		}

		return dateSql;
	}

	public static java.util.Date TimestampToDateUtil(java.sql.Timestamp dateTimetamp){

		java.util.Date dateUtil=new Date();

		if(dateTimetamp==null){
			return new Date();
		}
		else{
			dateUtil = new Date(dateTimetamp.getTime());
		}

		return dateUtil;
	}

	public static java.sql.Timestamp DateUtilToTimestamp(java.util.Date dateUtil){

		Timestamp stamp = new Timestamp(System.currentTimeMillis());

		if(dateUtil==null){
			return new Timestamp(System.currentTimeMillis());
		}
		else{
			stamp = new java.sql.Timestamp(dateUtil.getTime());
		}

		return stamp;
	}

	@SuppressWarnings("deprecation")
	public static java.util.Date SimplyDateFormatToDateUtil(String sdfDate){

		Date dateUtil =null;

		if(sdfDate==null || sdfDate.equals("")){
			return null;
		}
		else{
			int diaT = Integer.parseInt(sdfDate.substring(0, 2));
			int montT = Integer.parseInt(sdfDate.substring(3, 5));
			int yearT = Integer.parseInt(sdfDate.substring(6, 10));
			dateUtil = new Date(yearT, montT, diaT);
		}
		return dateUtil;

	}
	
	
}
