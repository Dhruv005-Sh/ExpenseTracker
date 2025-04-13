package Food;

/**
 * Custom exception class to indicate when a requested Food item is not found.
 * Thrown when attempting to access or manipulate a non-existent Food entity.
 * Extends RuntimeException to make it an unchecked exception.
 */
public class FoodNotFoundException extends RuntimeException {


    /**
     * Constructs a new FoodNotFoundException with the specified error message.
     *
     * @param message the detail message describing the food item that wasn't found
     */
    public FoodNotFoundException(String message) {
        super(message);
    }
}
