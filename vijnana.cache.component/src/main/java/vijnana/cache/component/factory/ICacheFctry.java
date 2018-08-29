package vijnana.cache.component.factory;

import java.io.Serializable;

public interface ICacheFctry {
    public Object Buscar(String var1) throws Exception;

    public void Enviar(String var1, Serializable var2) throws Exception;

    public boolean Eliminar(String var1) throws Exception;
}