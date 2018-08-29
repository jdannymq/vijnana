package vijnana.wsrest.client.exception;

import java.io.Serializable;

public class VijnanaClientException extends Exception implements Serializable{

	private static final long serialVersionUID = 4015762990909818794L;

	public VijnanaClientException(){
		super();
	}

	public VijnanaClientException(String message){
		super(message);
	}
	
	public VijnanaClientException(String message, Throwable cause){
		super(message, cause);
	}
	
	
	public VijnanaClientException(Throwable cause){
		super(cause);
	}
}
