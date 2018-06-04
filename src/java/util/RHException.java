package util;

public class RHException extends Exception {

    private String detalle;
    private String clase;

    /**
     * Metodo constructor que recoge la descripcion del error que genero la
     * excepcion.
     *
     * @param error cadena que contiene la descripcion del error.
     */
    public RHException(String clase, String error) {
        super(error);
        this.clase = clase;
        detalle = error;
    }

    public String toString() {
        return "[" + clase + "] " + detalle;
    }
}
