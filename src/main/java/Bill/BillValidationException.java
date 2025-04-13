package Bill;

/**
 * Custom exception class to indicate validation failures for Bill entities.
 * Thrown when a Bill object fails business logic or data validation checks.
 * Extends RuntimeException to make it an unchecked exception.
 */
public class BillValidationException extends RuntimeException {

    /**
     * Constructs a new BillValidationException with the specified error message.
     *
     * @param message the detail message describing the validation failure
     */
    public BillValidationException(String message) {
        super(message);
    }
}
