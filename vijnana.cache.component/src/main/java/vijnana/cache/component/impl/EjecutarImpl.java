package vijnana.cache.component.impl;


import java.io.Serializable;

import vijnana.cache.component.ICacheComponent;
import vijnana.cache.component.factory.ICacheFctry;

public class EjecutarImpl implements ICacheComponent {
    private ICacheFctry objCache;

    public EjecutarImpl(ICacheFctry implementacion) {
        this.objCache = implementacion;
    }

    public Object Buscar(String idEntrada) {
        try{
        	return this.objCache.Buscar(idEntrada);
        }catch(Exception e){
        	return null;
        }
    }

    public void Enviar(String idEntrada, Serializable objeto) {
        try{
        	this.objCache.Enviar(idEntrada, objeto);
        }catch(Exception e){
        
        }
    }

    public void Eliminar(String idEntrada) {
        try{
        	this.objCache.Eliminar(idEntrada);
        }catch(Exception e){
        }
        }
}