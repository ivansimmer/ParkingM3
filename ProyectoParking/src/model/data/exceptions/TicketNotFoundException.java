package model.data.exceptions;

/**
 *
 * @author ivansimmer
 */
public class TicketNotFoundException extends Exception {
    
    // Excepcion para cuando no existe un ticket
    
    public TicketNotFoundException (String errorMessage) {
        super(errorMessage);
    }
}
