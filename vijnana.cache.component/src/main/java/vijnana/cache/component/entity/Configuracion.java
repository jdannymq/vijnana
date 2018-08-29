package vijnana.cache.component.entity;

public class Configuracion {
    private int intMaxCnxPorHost = 5;
    private int intMaxTotalCnx = 50;
    private int intCnxTimeOut = 5000;
    private int intSoTimeOut = 5000;

    public int getMaxCnxPorHost() {
        return this.intMaxCnxPorHost;
    }

    public void setMaxCnxPorHost(int valor) {
        this.intMaxCnxPorHost = valor;
    }

    public int getMaxTotalCnx() {
        return this.intMaxTotalCnx;
    }

    public void setMaxTotalCnx(int valor) {
        this.intMaxTotalCnx = valor;
    }

    public int getCnxTimeOut() {
        return this.intCnxTimeOut;
    }

    public void setCnxTimeOut(int valor) {
        this.intCnxTimeOut = valor;
    }

    public int getSoTimeOut() {
        return this.intSoTimeOut;
    }

    public void setSoTimeOut(int valor) {
        this.intSoTimeOut = valor;
    }
}