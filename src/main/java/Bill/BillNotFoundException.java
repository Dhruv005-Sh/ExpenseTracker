package Bill;

/**
 * Custom runtime exception to indicate that a requested Bill was not found.
 * This exception is typically thrown when attempting to access or manipulate
 * a Bill that doesn't exist in the system.
 */
public class BillNotFoundException extends RuntimeException {

    /**
     * Constructs a new BillNotFoundException with the specified detail message.
     *
     * @param message the detail message that describes the reason for the exception
     */
    public BillNotFoundException(String message) {
        super(message);
    }
}
