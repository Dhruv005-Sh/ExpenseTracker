package Bill;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing Bill entities in the database.
 * Provides CRUD operations and custom query methods for Bill objects.
 * Extends JpaRepository to inherit standard JPA operations.
 */
public interface BillRepository extends JpaRepository<Bill, Long> {

    /**
     * Finds a bill by its type.
     *
     * @param billType the type of bill to search for
     * @return an Optional containing the matching bill if found, empty otherwise
     */
    Optional<Bill> findByBillType(String billType);

    /**
     * Finds all bills with price greater than the specified value.
     *
     * @param price the minimum price threshold (exclusive)
     * @return a list of bills meeting the price criteria
     */
    List<Bill> findByPriceGreaterThan(double price);

    /**
     * Finds a bill by its ID.
     *
     * @param id the ID of the bill to search for
     * @return the ID of the matching bill if found
     */
    Long Id(long id);
}
