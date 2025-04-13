package Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * REST controller for handling food-related HTTP requests.
 * Provides endpoints for CRUD operations on food items.
 */
@RestController
@RequestMapping("/api/foods")
@Validated
public class FoodController {
    private final FoodService foodService;

    /**
     * Constructs a new FoodController with the specified food service.
     *
     * @param foodService the food service implementation to be used
     */
    @Autowired
    public FoodController(@Qualifier("databaseFoodService")FoodService foodService) {
        this.foodService = foodService;
    }

    /**
     * Creates a new food.
     *
     * @param food The food information to create
     * @return The created food with HTTP status 201 (created)
     */
    @PostMapping
    public ResponseEntity<Food> createFood( @RequestBody Food food){
        Food savedFood = foodService.createFood(food);
        return new  ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }

    /**
     * Retrieves all food items.
     *
     * @return ResponseEntity containing a list of all foods and HTTP status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Food>> getAllFood(){
        List<Food> foods= foodService.getAllFoods();
        return ResponseEntity.ok(foods);
    }

    /**
     * Retrieves a food item by its ID.
     *
     * @param id the ID of the food to retrieve
     * @return ResponseEntity containing the food if found (HTTP 200),
     *         or HTTP 404 (NOT FOUND) if the food doesn't exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable long id){
        Food food = foodService.getFoodById(id);
        if(food != null){
            return ResponseEntity.ok(food);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Retrieves a food item by its name.
     *
     * @param name the name of the food to retrieve
     * @return ResponseEntity containing the food if found (HTTP 200),
     *         or HTTP 404 (NOT FOUND) if the food doesn't exist
     */
    @GetMapping("/byName")
    public ResponseEntity<Food> getFoodByName(@RequestParam String name){
        Food food = foodService.getFoodByName(name);
        if(food != null){
            return ResponseEntity.ok(food);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Deletes a food item by its ID.
     *
     * @param id the ID of the food to delete
     * @return ResponseEntity with success message if deleted (HTTP 200),
     *         or error message with HTTP 404 (NOT FOUND) if food doesn't exist
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable  long id){
        boolean deleted = foodService.deleteFood(id);
    if(deleted){
        return ResponseEntity.ok("Food deleted successfully");
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food with not found");
    }
}
