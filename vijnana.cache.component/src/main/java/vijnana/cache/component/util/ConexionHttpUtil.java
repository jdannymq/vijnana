package vijnana.cache.component.util;

import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import vijnana.cache.component.entity.Configuracion;


public class ConexionHttpUtil {
    private HttpClient objHttpClte;
    private Configuracion objConfig;
    private HttpConnectionManagerParams objHttpPars;
    private MultiThreadedHttpConnectionManager objHttpMangr;
    private static Log objLog = LogFactory.getLog((String)"ConexionHttpUtil");

    public ConexionHttpUtil(Configuracion objeto) {
        this.objConfig = objeto;
    }

    public void Cargar() {
        this.objHttpMangr = new MultiThreadedHttpConnectionManager();
        this.objHttpPars = new HttpConnectionManagerParams();
        this.objHttpPars.setDefaultMaxConnectionsPerHost(this.objConfig.getMaxCnxPorHost());
        this.objHttpPars.setMaxTotalConnections(this.objConfig.getMaxTotalCnx());
        this.objHttpPars.setConnectionTimeout(this.objConfig.getCnxTimeOut());
        this.objHttpPars.setSoTimeout(this.objConfig.getSoTimeOut());
        this.objHttpMangr.setParams(this.objHttpPars);
    }

    public int Ejecutar(HttpMethod metodo) {
        this.objHttpClte = new HttpClient((HttpConnectionManager)this.objHttpMangr);
        try {
            this.objHttpClte.executeMethod(metodo);
        }
        catch (HttpException ex) {
            objLog.error((Object)"Ejecutar()", (Throwable)ex);
        }
        catch (IOException ex) {
            objLog.error((Object)"Ejecutar()", (Throwable)ex);
        }
        return -1;
    }
}