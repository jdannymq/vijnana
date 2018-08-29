package vijnana.utilidades.component.apiproperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ServerProperties
extends Properties {
    private String strSptr = System.getProperty("file.separator");
    private static final long serialVersionUID = 1;

    protected ServerProperties() throws FileNotFoundException, IOException {
//      String strRuta = System.getProperty("catalina.base") + "/app.properties";
    	String strRuta = System.getProperty("catalina.base").concat(this.strSptr).concat("app.properties");
        super.load(new FileInputStream(strRuta));
    }

//    public AppProperties(TipoAplicacion tipoAplicacion) throws FileNotFoundException, IOException {
//        switch (tipoAplicacion.getTipoAplicacion()) {
//            case 1: {
//                String strRuta = System.getProperty("catalina.base").concat(this.strSptr).concat("app.properties");
//                super.load(new FileInputStream(strRuta));
//                break;
//            }
//            case 2: {
//                String strRuta = AppGeneral.obtenerAchivo().getAbsoluteFile().getPath().concat(this.strSptr).concat("app.properties");
//                super.load(new FileInputStream(strRuta));
//                break;
//            }
//            case 3: {
//                break;
//            }
//            default: {
//                String strRuta = System.getProperty("catalina.base").concat(this.strSptr).concat("app.properties");
//                super.load(new FileInputStream(strRuta));
//            }
//        }
//    }
    
    
//    public AppProperties() throws FileNotFoundException, IOException {
//        switch () {
//            case 1: {
//                String strRuta = System.getProperty("catalina.base").concat(this.strSptr).concat("app.properties");
//                super.load(new FileInputStream(strRuta));
//                break;
//            }
//            case 2: {
//                String strRuta = AppGeneral.obtenerAchivo().getAbsoluteFile().getPath().concat(this.strSptr).concat("app.properties");
//                super.load(new FileInputStream(strRuta));
//                break;
//            }
//            case 3: {
//                break;
//            }
//            default: {
//                String strRuta = System.getProperty("catalina.base").concat(this.strSptr).concat("app.properties");
//                super.load(new FileInputStream(strRuta));
//            }
//        }
//    }
}