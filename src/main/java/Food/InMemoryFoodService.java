package Food;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory implementation of the FoodService interface.
 * Provides temporary storage of Food entities in an ArrayList.
 * Marked as Spring Service component for dependency injection.
 */
@Service
public class InMemoryFoodService implements FoodService {
    private final List<Food> foods;

    /**
     * Constructs a new InMemoryFoodService with empty storage.
     */
    public InMemoryFoodService(){
        this.foods=new ArrayList<>();
    }

    /**
     * Adds a new food item to the in-memory storage.
     *
     * @param food the food item to be created
     * @return the created food item
     */
    @Override
    public Food createFood(Food food){
        foods.add(food);
        return food;
    }

    /**
     * Retrieves all food items from storage.
     *
     * @return list of all stored food items
     */
    @Override
    public List<Food> getAllFoods(){
        return foods;
    }


    /**
     * Finds a food item by its unique identifier.
     *
     * @param id the ID of the food item to find
     * @return the found food item, or null if not found
     */
    @Override
    public Food getFoodById(long id){
        for(Food food:foods){
            if (food.getId()==id){
                return food;
            }
        }
        return null;
    }

    /**
     * Finds a food item by its exact name.
     *
     * @param name the exact name of the food item to find
     * @return the found food item, or null if not found
     */
    @Override
    public Food getFoodByName(String name){
        for(Food food:foods){
            if (food.getName().equals(name)){
                return food;
            }
        }
        return null;
    }

    /**
     * Removes a food item from storage by its ID.
     *
     * @param id the ID of the food item to remove
     * @return true if removal was successful, false otherwise
     */
    @Override
    public boolean deleteFood(long id){
        Food food=getFoodById(id);
        if (food!=null){
            foods.remove(food);
            return true;
        }
        return false;
    }

}
