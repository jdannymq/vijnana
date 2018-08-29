package vijnana.utilidades.component.utilidades;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AppNumber {
    public static synchronized BigDecimal redondear(BigDecimal numero, int decimales) {
        return numero.setScale(decimales, RoundingMode.HALF_UP);
    }
}