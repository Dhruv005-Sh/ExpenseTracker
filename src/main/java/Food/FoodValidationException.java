package Food;

public class FoodValidationException extends RuntimeException {

 /**
 * Custom exception class to indicate validation failures for Food entities.
 * Thrown when a Food object fails business logic or data validation checks.
 * Extends RuntimeException to make it an unchecked exception.
 */
public class FoodValidationException extends RuntimeException {

    /**
     * Constructs a new FoodValidationException with the specified error message.
     *
     * @param message the detail message describing the validation failure
     */
    public FoodValidationException(String message) {
        super(message);
    }
}
