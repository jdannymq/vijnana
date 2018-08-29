package vijnana.cache.component.factory.impl;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import net.sf.ehcache.Element;
import vijnana.cache.component.entity.Configuracion;
import vijnana.cache.component.factory.ICacheFctry;
import vijnana.cache.component.util.ConexionHttpUtil;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CacheDstbdFctry implements ICacheFctry {
    private String strUrlServ;
    private int intReadTmpOut = 5000;
    private int intMaxEntds;
    private String strReptr;
    private ConexionHttpUtil objCxHttp;
    private static Log objLog = LogFactory.getLog((String)"CacheDstbdFctry");

    public CacheDstbdFctry(String UrlServ, String Repositorio) {
        this.strUrlServ = UrlServ;
        this.strReptr = Repositorio;
        this.objCxHttp = new ConexionHttpUtil(new Configuracion());
        this.cargarConfiguracion();
    }

    private void cargarConfiguracion() {
        this.objCxHttp.Cargar();
    }

    public Object Buscar(String idLlave) throws Exception{
        ObjectInputStream objIStream = null;
        String strUrl = StringUtils.join((Object[])new String[]{this.strUrlServ, this.strReptr, idLlave}, (String)"/");
        GetMethod objMtd = new GetMethod(strUrl);
        this.configureMethod((HttpMethod)objMtd);
        int intEstdo = -1;
        try {
            intEstdo = this.objCxHttp.Ejecutar((HttpMethod)objMtd);
            if (intEstdo == 404) {
                objLog.info((Object)"Error: IdEntrada no existe el repositorio...");
                Object var7_6 = null;
                return var7_6;
            }
            if (objMtd.getStatusLine().getStatusCode() == 200) {
                objIStream = new ObjectInputStream(objMtd.getResponseBodyAsStream());
                Element objElmt = (Element)objIStream.readObject();
                Object object = objElmt.getObjectValue();
                return object;
            }
            Object var7_8 = null;
            return var7_8;
        }
        catch (IOException ex) {
            objLog.warn((Object)"Error buscar() - ".concat(String.valueOf(intEstdo)), (Throwable)ex);
            throw new Exception((Throwable)ex);
        }
        catch (ClassNotFoundException ex) {
            objLog.error((Object)"Error buscar() ", (Throwable)ex);
            throw new Exception((Throwable)ex);
        }
        finally {
            IOUtils.closeQuietly((InputStream)objIStream);
            objMtd.releaseConnection();
        }
    }

    public void Enviar(String idLlave, Serializable objeto) {
        ObjectOutputStream objOStream = null;
        ByteArrayOutputStream objBtOStream = null;
        String strUrl = StringUtils.join((Object[])new String[]{this.strUrlServ, this.strReptr, idLlave}, (String)"/");
        Element objElmt = new Element((Serializable)((Object)idLlave), objeto);
        PutMethod objMtd = new PutMethod(strUrl);
        this.configureMethod((HttpMethod)objMtd);
        int intEstdo = -1;
        try {
            objBtOStream = new ByteArrayOutputStream();
            objOStream = new ObjectOutputStream(objBtOStream);
            objOStream.writeObject((Object)objElmt);
            objMtd.setRequestEntity((RequestEntity)new InputStreamRequestEntity((InputStream)new ByteArrayInputStream(objBtOStream.toByteArray())));
            intEstdo = this.objCxHttp.Ejecutar((HttpMethod)objMtd);
        }
        catch (Exception ex) {
            objLog.warn((Object)"Error enviar() - ".concat(String.valueOf(intEstdo)), (Throwable)ex);
        }
        finally {
            IOUtils.closeQuietly((OutputStream)objOStream);
            objMtd.releaseConnection();
        }
    }

    public boolean Eliminar(String idLlave) {
        boolean Ejctd = false;
        String strUrl = StringUtils.join((Object[])new String[]{this.strUrlServ, this.strReptr, idLlave}, (String)"/");
        DeleteMethod objMtd = new DeleteMethod(strUrl);
        this.configureMethod((HttpMethod)objMtd);
        int intEstdo = -1;
        try {
            intEstdo = this.objCxHttp.Ejecutar((HttpMethod)objMtd);
            Ejctd = true;
        }
        catch (Exception ex) {
            objLog.warn((Object)"Error eliminar() - ".concat(String.valueOf(intEstdo)), (Throwable)ex);
        }
        finally {
            objMtd.releaseConnection();
        }
        return Ejctd;
    }

    private void configureMethod(HttpMethod objeto) {
        if (this.intReadTmpOut > 0) {
            objeto.getParams().setSoTimeout(this.intReadTmpOut);
        }
        if (this.intMaxEntds > 0) {
            objeto.getParams().setParameter("http.method.retry-handler", (Object)new DefaultHttpMethodRetryHandler(this.intMaxEntds, false));
        }
    }
}