package vijnana.utilidades.component.utilidades;

public enum TipoEstado {
	Inactivo(0),
	Activo(1)
	;
    
    private int idTipoEstado;

    private TipoEstado(int tipoAplicacion) {
        this.idTipoEstado = tipoAplicacion;
    }

    public int getTipoEstado() {
        return this.idTipoEstado;
    }

    public static TipoEstado fromInteger(int x) {
        switch (x) {
            case 0: {
                return Inactivo;
            }
            case 1: {
                return Activo;
            }
        }
        return Inactivo;
    }
}