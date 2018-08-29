package vijnana.cache.component;

import java.io.Serializable;

public interface ICacheComponent {
    public Object Buscar(String var1);

    public void Enviar(String var1, Serializable var2);

    public void Eliminar(String var1);
}
