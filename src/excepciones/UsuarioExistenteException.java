package excepciones;

public class UsuarioExistenteException extends Exception {
    public UsuarioExistenteException() {
        super("No se encontró ningún vehículo que cumpla con los requisitos del viaje.");
    }

    public UsuarioExistenteException(String message) {
        super(message);
        
    }
}
