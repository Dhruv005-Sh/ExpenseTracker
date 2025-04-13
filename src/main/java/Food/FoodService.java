package Food;

import java.util.List;


/**
 * Service interface for managing Food entities and business operations.
 * Provides methods for creating, retrieving, and deleting food items.
 * Throws custom exceptions for validation and not-found scenarios.
 */
public interface FoodService {

    /**
     * Creates and persists a new food item in the system.
     *
     * @param food the food object to be created
     * @return the created food object with generated ID
     * @throws FoodValidationException if the food data fails validation checks
     */
    Food createFood(Food food) throws FoodValidationException;

    /**
     * Retrieves all food items available in the system.
     *
     * @return a list of all food items
     * @throws FoodNotFoundException if no food items are found
     */
    List<Food> getAllFoods() throws FoodNotFoundException;

    /**
     * Retrieves a specific food item by its unique identifier.
     *
     * @param id the ID of the food item to retrieve
     * @return the requested food item
     * @throws FoodNotFoundException if no food item with the given ID exists
     */
    Food getFoodById(long id) throws FoodNotFoundException;

    /**
     * Retrieves a specific food item by its exact name.
     *
     * @param name the exact name of the food item to retrieve
     * @return the requested food item
     * @throws FoodNotFoundException if no food item with the given name exists
     */
    Food getFoodByName(String name) throws FoodNotFoundException;

    /**
     * Deletes a food item from the system by its ID.
     *
     * @param id the ID of the food item to delete
     * @return true if deletion was successful, false otherwise
     */
    boolean deleteFood(long id);
}
