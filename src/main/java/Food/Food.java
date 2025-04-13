package Food;

import jakarta.persistence.*;


import org.antlr.v4.runtime.misc.NotNull;
import java.util.Objects;

/**
 * Represents a Food entity in the system.
 * This class maps to a database table and contains information about food items,
 * including their name and price.
 */
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    /**
     * The name of the food item. Cannot be null.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The price of the food item. Cannot be null.
     */
    @Column(nullable = false)
    private double price;

    /**
     * Default constructor required by JPA.
     */
    public Food() {
    }

    /**
     * Constructs a new Food item with specified details.
     *
     * @param id the unique identifier for the food item
     * @param name the name of the food item
     * @param price the price of the food item
     */
    public Food(long id, String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the unique identifier of the food item.
     *
     * @return the food item's ID
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the food item.
     *
     * @param id the ID to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the name of the food item.
     *
     * @return the food item's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the food item.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the food item.
     *
     * @return the food item's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the food item.
     *
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Compares this food item to another object for equality.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return id == food.id && Double.compare(price, food.price) == 0 && Objects.equals(name, food.name);
    }

    /**
     * Generates a hash code for this food item.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    /**
     * Returns a string representation of the food item.
     *
     * @return string representation of the food item
     */
    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
