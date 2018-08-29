package vijnana.cache.component.exception;

import java.io.Serializable;

public class VijnanaCacheException extends Exception implements Serializable{

	private static final long serialVersionUID = 4015762990909818794L;

	public VijnanaCacheException(){
		super();
	}

	public VijnanaCacheException(String message){
		super(message);
	}
	
	public VijnanaCacheException(String message, Throwable cause){
		super(message, cause);
	}
	
	
	public VijnanaCacheException(Throwable cause){
		super(cause);
	}
}
