package Bill;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory implementation of the BillService interface.
 * Provides temporary storage of bills in an ArrayList for development or testing purposes.
 * Not persistent - all data is lost when the application restarts.
 */
@Service
public class InMemoryBillService implements BillService {
    private final List<Bill> bills;

    /**
     * Constructs a new InMemoryBillService with an empty list of bills.
     * Initializes the in-memory storage for bill entities.
     */
    public InMemoryBillService() {
        this.bills = new ArrayList<>();
    }

    /**
     * Adds a new bill to the in-memory storage.
     * @param bill The bill object to be stored
     * @return The same bill object that was stored
     */
    @Override
    public Bill createBill(Bill bill) {
        bills.add(bill);
        return bill;
    }

    /**
     * Retrieves all bills from the in-memory storage.
     * @return An empty list (current implementation always returns empty list)
     */
    @Override
    public List<Bill> getAllBill()  {
        return List.of();
    }

    /**
     * Finds a bill by its unique identifier.
     * @param id The ID of the bill to search for
     * @return The matching bill, or null if not found
     */
    @Override
    public Bill getBillById(long id)  {
        for (Bill bill : bills) {
            if (bill.getId() == id) {
                return bill;
            }
        }
        return null;
    }

    /**
     * Finds a bill by its type.
     * @param billType The type of bill to search for
     * @return The matching bill, or null if not found
     */
    @Override
    public Bill getBillByBillType(String billType)  {
        for (Bill bill : bills) {
            if (bill.getBillType().equals(billType)) {
                return bill;
            }
        }
        return null;
    }

    /**
     * Removes a bill from the in-memory storage by its ID.
     * @param id The ID of the bill to remove
     * @return Always returns false in current implementation
     */
    @Override
    public boolean deleteBill(long id)  {
        for (Bill bill : bills) {
            if (bill.getId() == id) {
                bills.remove(bill);
            }
        }
        return false;
    }
}
