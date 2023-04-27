package wax.wax.Dominio.excepciones;

public class DatosInvalidosException extends RuntimeException {
    public DatosInvalidosException(String message) {
        super(message);
    }
}