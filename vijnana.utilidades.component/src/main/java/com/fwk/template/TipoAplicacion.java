//package com.fwk.template;
//
//public enum TipoAplicacion {
//	  WS(1),  APP(2);
//	  
//	  private int idTipoAplicacion;
//	  
//	  private TipoAplicacion(int tipoAplicacion) {
//	    idTipoAplicacion = tipoAplicacion;
//	  }
//	  
//	  public int getTipoAplicacion() {
//	    return idTipoAplicacion;
//	  }
//	  
//	  public static TipoAplicacion fromInteger(int x) {
//	    switch (x) {
//	    case 1: 
//	      return WS;
//	    }
//	    return APP;
//	  }
//	}