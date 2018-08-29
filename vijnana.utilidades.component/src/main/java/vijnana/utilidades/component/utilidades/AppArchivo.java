//package vijnana.utilidades.component.utilidades;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.net.URL;
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Marshaller;
//
//public class AppArchivo {
//    private static File WORKING_DIRECTORY;
//
////    public static synchronized String getPropertie(TipoAplicacion tipoAplicacion, String key) throws FileNotFoundException, IOException {
////        return new AppProperties(tipoAplicacion).getProperty(key);
////    }
//    
//    public static synchronized String getPropertie(String key) throws FileNotFoundException, IOException {
//        return new AppProperties().getProperty(key);
//    }
//
//    public static File obtenerAchivo() {
//        String strRecurso = AppArchivo.class.getSimpleName() + ".class";
//        if (WORKING_DIRECTORY == null) {
//            try {
//                URL objUrl = AppArchivo.class.getResource(strRecurso);
//                if (objUrl.getProtocol().equals("file")) {
//                    File objFile = new File(objUrl.toURI());
//                    while (!(objFile = objFile.getParentFile()).isDirectory()) {
//                    }
//                    WORKING_DIRECTORY = objFile;
//                } else if (objUrl.getProtocol().equals("jar")) {
//                    String expected = "!/" + strRecurso;
//                    String s = objUrl.toString();
//                    s = s.substring(4);
//                    s = s.substring(0, s.length() - expected.length());
//                    File objFile = new File(new URL(s).toURI());
//                    while (!(objFile = objFile.getParentFile()).isDirectory()) {
//                    }
//                    WORKING_DIRECTORY = objFile;
//                }
//            }
//            catch (Exception e) {
//                WORKING_DIRECTORY = new File(".");
//            }
//        }
//        return WORKING_DIRECTORY;
//    }
//
//    public boolean generarArchivoXMLDesdeObjetoXML(Object objeto, String nombreArchivo, String ruta) {
//        try {
//            File file = new File(ruta + nombreArchivo + ".xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(objeto.getClass());
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//            jaxbMarshaller.setProperty("jaxb.formatted.output", true);
//            jaxbMarshaller.marshal(objeto, file);
//            jaxbMarshaller.marshal(objeto, System.out);
//            return true;
//        }
//        catch (Exception e) {
//            return false;
//        }
//    }
//}