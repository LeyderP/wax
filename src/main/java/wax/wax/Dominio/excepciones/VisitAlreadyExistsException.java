package wax.wax.Dominio.excepciones;

public class VisitAlreadyExistsException extends RuntimeException {
    public VisitAlreadyExistsException(String message) {
        super(message);
    }
}