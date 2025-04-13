package Bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for bill management operations.
 * Provides concrete implementation of {@link BillService} using database persistence.
 * Handles business logic and interacts with {@link BillRepository} for data access.
 */
@Service
public class DatabaseBillService implements BillService {
    private final BillRepository billRepository;

    /**
     * Constructs a new DatabaseBillService with the specified repository.
     *
     * @param billRepository the bill repository used for data access operations
     */
    @Autowired
    public DatabaseBillService(BillRepository billRepository) {this.billRepository = billRepository;}

    /**
     * Creates and persists a new bill after validation.
     *
     * @param bill the bill entity to be created
     * @return the persisted bill entity
     * @throws BillValidationException if the bill is null or invalid
     */
    @Override
    public Bill createBill(Bill bill) {
        if (bill == null) {
            throw new BillValidationException("bill cannot be null");
        }
        return billRepository.save(bill);
    }

    /**
     * Retrieves all bills from the database.
     *
     * @return list of all bills
     * @throws BillNotFoundException if no bills exist in the database
     */
    @Override
    public List<Bill> getAllBill(){
        List<Bill> billList = billRepository.findAll();
        if (billList.isEmpty()) {
            throw new BillNotFoundException("no bill found");
        }
        return billRepository.findAll();
    }

    /**
     * Retrieves a bill by its unique identifier.
     *
     * @param id the unique identifier of the bill
     * @return the requested bill entity
     * @throws BillNotFoundException if no bill exists with the given ID
     */
    @Override
    public Bill getBillById(long id) {
        return billRepository.findById(id).orElseThrow(() -> new BillNotFoundException("Bill with id " + id + " not found"));
    }

    /**
     * Retrieves a bill by its type.
     *
     * @param billType the type of bill to search for
     * @return the matching bill entity
     * @throws BillNotFoundException if no bill exists with the given type
     */
    @Override
    public Bill getBillByBillType(String billType) {
        return billRepository.findByBillType(billType).orElseThrow(() -> new BillNotFoundException("Bill with billType" + billType + "not found"));
    }

    /**
     * Deletes a bill by its unique identifier.
     *
     * @param id the unique identifier of the bill to delete
     * @return true if the bill was successfully deleted, false otherwise
     * @throws BillNotFoundException if no bill exists with the given ID
     */
    @Override
    public boolean deleteBill(long id) {
        if (billRepository.existsById(id)) {
            billRepository.deleteById(id);
            return true;
        }else {throw new BillNotFoundException ("Bill with id" + id + "not found");}
    }
}
