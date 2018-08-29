package vijnana.utilidades.component.exception;

import java.io.Serializable;

public class VijnanaUtilidadesException extends Exception implements Serializable{

	private static final long serialVersionUID = 4015762990909818794L;

	public VijnanaUtilidadesException(){
		super();
	}

	public VijnanaUtilidadesException(String message){
		super(message);
	}
	
	public VijnanaUtilidadesException(String message, Throwable cause){
		super(message, cause);
	}
	
	
	public VijnanaUtilidadesException(Throwable cause){
		super(cause);
	}
}
