package Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for food management operations.
 * Provides database-backed implementation of {@link FoodService} interface.
 * Handles business logic and data persistence using {@link FoodRepository}.
 */
@Service
public class DatabaseFoodService implements FoodService {
    /**
     * The repository used to access the database.
     */
    private final FoodRepository foodRepository;


    /**
     * Constructs a new DatabaseFoodService with the specified repository.
     *
     * @param foodRepository the food repository used for data persistence
     */
    @Autowired
    public DatabaseFoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }


    /**
     * Creates and persists a new food item after validation.
     *
     * @param food the food item to be created
     * @return the persisted food item
     * @throws FoodValidationException if the food is null or invalid
     */
    @Override
    public Food createFood(Food food) {
        if (food == null) {
            throw new FoodValidationException("Food cannot be null");
        }
        return foodRepository.save(food);
    }


    /**
     * Retrieves all food items from the database.
     *
     * @return list of all food items
     * @throws FoodNotFoundException if no food items exist in the database
     */
    @Override
    public List<Food> getAllFoods() {
        List<Food> foodList = foodRepository.findAll();
        if (foodList.isEmpty()) {
            throw new FoodNotFoundException("No food found");
        }
        return foodRepository.findAll();
    }


    /**
     * Retrieves a food item by its unique identifier.
     *
     * @param id the unique identifier of the food item
     * @return the requested food item
     * @throws FoodNotFoundException if no food exists with the given ID
     */
    @Override
    public Food getFoodById(long id) {
        return foodRepository.findById(id).orElseThrow(() -> new FoodNotFoundException("Food with id " + id + " not found"));
    }


    /**
     * Retrieves a food item by its name.
     *
     * @param name the name of the food item to search for
     * @return the matching food item
     * @throws FoodNotFoundException if no food exists with the given name
     */
    @Override
    public Food getFoodByName(String name) {
        return foodRepository.findByName(name).orElseThrow(() -> new FoodNotFoundException("Food with name " + name + " not found"));
    }


    /**
     * Deletes a food item by its unique identifier.
     *
     * @param id the unique identifier of the food item to delete
     * @return true if the food item was successfully deleted
     * @throws FoodNotFoundException if no food exists with the given ID
     */
    @Override
    public boolean deleteFood(long id) {
        if (foodRepository.existsById(id)) {
            foodRepository.deleteById(id);
            return true;
        }else
        {throw new FoodNotFoundException("Food with id " + id + " not found");}
    }

    }



