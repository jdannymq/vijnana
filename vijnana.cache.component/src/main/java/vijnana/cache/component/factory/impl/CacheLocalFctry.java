package vijnana.cache.component.factory.impl;

import java.io.Serializable;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import vijnana.cache.component.factory.ICacheFctry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class CacheLocalFctry implements ICacheFctry {
    private Cache _objCache;
    private static Log _objLog = LogFactory.getLog((String)"CacheLocalFctry");

    public CacheLocalFctry(String Repositorio) {
        this._objCache = new CacheManager().getCache(Repositorio);
    }

    public Object Buscar(String idLlave) throws Exception{
        Object objeto = null;
        try {
            objeto = this._objCache.get((Serializable)((Object)idLlave)).getObjectValue();
        }
        catch (Exception ex) {
            _objLog.error((Object)ex);
            throw new Exception((Throwable)ex);
        }
        return objeto;
    }

    public void Enviar(String idLlave, Serializable objeto) throws Exception{
        try {
            this._objCache.put(new Element((Serializable)((Object)idLlave), objeto));
        }
        catch (Exception ex) {
            _objLog.error((Object)ex);
            throw new Exception((Throwable)ex);
        }
    }

    public boolean Eliminar(String idLlave) throws Exception{
        boolean blnBorrado = false;
        try {
            blnBorrado = this._objCache.remove((Serializable)((Object)idLlave));
        }
        catch (Exception ex) {
            _objLog.error((Object)ex);
            throw new Exception((Throwable)ex);
        }
        return blnBorrado;
    }
}