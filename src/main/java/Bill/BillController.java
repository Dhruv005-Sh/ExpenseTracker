package Bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Bill operations.
 * Provides endpoints for creating, retrieving, and deleting bills.
 */
@RestController
@RequestMapping("/api/Bills")
@Validated
public class BillController {
    private final BillService billService;

    /**
     * Constructs a new BillController with the specified BillService.
     *
     * @param billService the bill service implementation to be used
     */
    @Autowired
    public BillController(@Qualifier("databaseBillService") BillService billService) {
        this.billService = billService;
    }

    /**
     * Creates a new bill.
     *
     * @param bill the bill to be created
     * @return ResponseEntity containing the created bill and HTTP status 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        Bill savedBill = billService.createBill(bill);
        return new ResponseEntity<>(savedBill, HttpStatus.CREATED);
    }

    /**
     * Retrieves all bills.
     *
     * @return ResponseEntity containing a list of all bills and HTTP status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        List<Bill> bills = billService.getAllBill();
        return  ResponseEntity.ok(bills);
    }

    /**
     * Retrieves a bill by its ID.
     *
     * @param id the ID of the bill to retrieve
     * @return ResponseEntity containing the requested bill if found (HTTP status 200),
     *         or HTTP status 404 (NOT FOUND) if the bill doesn't exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable long id) {
        Bill bill = billService.getBillById(id);
        if (bill != null) {
            return ResponseEntity.ok(bill);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Retrieves a bill by its type.
     *
     * @param billType the type of bill to retrieve
     * @return ResponseEntity containing the requested bill if found (HTTP status 200),
     *         or HTTP status 404 (NOT FOUND) if the bill doesn't exist
     */
    @GetMapping("/ByBillType")
    public ResponseEntity<Bill> getBillByBillType(@RequestParam String billType) {
        Bill bill = billService.getBillByBillType(billType);
        if (bill != null) {
            return ResponseEntity.ok(bill);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Deletes a bill by its ID.
     *
     * @param id the ID of the bill to delete
     * @return ResponseEntity with a success message if deleted (HTTP status 200),
     *         or an error message with HTTP status 404 (NOT FOUND) if the bill doesn't exist
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable long id) {
        boolean deleted= billService.deleteBill(id);
        if (deleted) {
            return ResponseEntity.ok("Bill deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bill not found");
    }

}
