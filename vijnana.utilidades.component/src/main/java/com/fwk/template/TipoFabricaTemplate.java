package com.fwk.template;

public enum TipoFabricaTemplate {
	  Velocity(1),  SinEspecificar(0);
	  
	  private int idTipoFabricaTemplate;
	  
	  private TipoFabricaTemplate(int tipoFabricaTemplate) {
	    idTipoFabricaTemplate = tipoFabricaTemplate;
	  }
	  
	  public int getTipoFabricaTemplate() {
	    return idTipoFabricaTemplate;
	  }
	  
	  public static TipoFabricaTemplate fromInteger(int x) {
	    switch (x) {
	    case 1: 
	      return Velocity;
	    }
	    return SinEspecificar;
	  }
	}