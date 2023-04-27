package wax.wax.Dominio.excepciones;

//Validar a través del ID si la visita existe
public class VisitatableNotFoundException extends RuntimeException {
    public VisitatableNotFoundException(String message) {
        super(message);
    }
}