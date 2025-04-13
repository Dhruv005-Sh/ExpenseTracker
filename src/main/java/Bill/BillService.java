package Bill;

import java.util.List;

/**
 * Service interface for managing bill-related business logic.
 * Defines operations for creating, retrieving, and deleting bills.
 */
public interface BillService {

    /**
     * Creates a new bill in the system.
     *
     * @param bill the bill object to be created
     * @return the created bill with generated identifiers
     * @throws BillValidationException if the bill data fails validation
     */
    Bill createBill (Bill bill) throws BillValidationException ;

    /**
     * Retrieves all bills from the system.
     *
     * @return a list of all bills
     * @throws BillNotFoundException if no bills are found
     */
    List<Bill> getAllBill() throws BillNotFoundException;

    /**
     * Retrieves a specific bill by its unique identifier.
     *
     * @param id the unique identifier of the bill
     * @return the requested bill
     * @throws BillNotFoundException if no bill exists with the given ID
     */
    Bill getBillById(long id) throws BillNotFoundException;

    /**
     * Retrieves a bill by its type.
     *
     * @param billType the type of bill to search for
     * @return the matching bill
     * @throws BillNotFoundException if no bill exists with the given type
     */
    Bill getBillByBillType(String billType) throws BillNotFoundException;

    /**
     * Deletes a bill from the system.
     *
     * @param id the unique identifier of the bill to delete
     * @return true if the bill was successfully deleted, false otherwise
     */
    boolean deleteBill(long id);
}
