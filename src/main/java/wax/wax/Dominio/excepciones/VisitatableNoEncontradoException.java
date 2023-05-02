package wax.wax.Dominio.excepciones;

//Validar a través del ID si la visita existe
public class VisitatableNoEncontradoException extends RuntimeException {
    public VisitatableNoEncontradoException(String message) {
        super(message);
    }
}