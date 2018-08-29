package vijnana.utilidades.component.utilidades;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ip {

	public static String direccionServer() {

		String direccionServer = null;
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			direccionServer = ip.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return direccionServer;

	}
}
