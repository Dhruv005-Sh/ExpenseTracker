package Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    /**
     * Finds a food by its name.
     * <f>
     * This custom method is created because JpaRepository doesn't provide a
     * built-in method to search by the food name. Spring Data JPA will automatically
     * implement this method based on its name following the pattern "findBy[PropertyName]".
     * <p>
     * The method returns an Optional object which may or may not contain a food,
     * avoiding potential null pointer exceptions when no food is found with the given name.
     *
     * @param name the name of the food to search for
     * @return an Optional containing the found food, or an empty Optional if no food exists with the given name
     */
    Optional<Food> findByName(String name);
    /**
     * Finds all products with a price greater than the specified value.
     * <p>
     * This method allows filtering products based on a minimum price threshold.
     * Spring Data JPA automatically implements this method based on its name
     * following the pattern "findBy[PropertyName][GreaterThan]".
     *
     * @param price the minimum price threshold
     * @return a list of products with prices greater than the specified value
     */
    List<Food> findByPriceGreaterThan(double price);
    

/**
 * Repository interface for managing Food entities in the database.
 * Provides CRUD operations and custom queries for Food items.
 * Extends JpaRepository to inherit standard JPA operations.
 */
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    /**
     * Finds a food item by its exact name match.
     *
     * @param name the exact name of the food item to search for
     * @return an Optional containing the found food item or empty if not found
     */
    Optional<Food> findByName(String name);

    /**
     * Finds all food items with price greater than the specified value.
     *
     * @param price the minimum price threshold (exclusive)
     * @return a list of food items meeting the price criteria
     */
    List<Food> findByPriceGreaterThan(double price);

    /**
     * Finds food items whose names contain the given keyword (case-insensitive).
     *
     * @param keyword the search term to look for in food names
     * @return a list of matching food items
     */
    List<Food> findByNameContainingIgnoreCase(String keyword);

    /**
     * Finds food items within a specified price range, ordered by price ascending.
     * Uses a custom JPQL query for the search.
     *
     * @param name the name parameter (note: appears to be incorrectly named for price range query)
     * @return a list of food items within the price range
     */
    @Query("select f from Food f where f.price BETWEEN ?1 AND ?2 ORDER BY f.price ASC ")
    List<Food> findFoodInPriceRange(String name);
}
