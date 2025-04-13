package TravelExpense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Travels in the application.
 * Provides endpoints for CRUD operations on Travels.
 */
@RestController
@RequestMapping("/api/travels")
@Validated
public class TravelController {
    private final TravelService travelService;

    @Autowired
    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    /**
     * Creates a new food.
     *
     * @param travel The Travel information to create
     * @return The created Travel with HTTP status 201 (created)
     */
    //Create - POST
    @PostMapping
    public ResponseEntity<Travel> createTravel(@RequestBody Travel travel) {
        Travel savedTravel = travelService.createTravel(travel);
        return new ResponseEntity<>(savedTravel, HttpStatus.CREATED);
    }

    //Read - GET
    /**
     * Retrieves all Travels from the system.
     *
     * @return ResponseEntity containing a list of all Travels with HTTP status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Travel>> getAllTravels() {
        List<Travel> travels=travelService.getAllTravels();
        return ResponseEntity.ok(travels);

    }

    /**
     * Retrieves a specific Travels by its ID.
     *
     * @param id the unique identifier of the Travel
     * @return ResponseEntity containing the travel with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the travel doesn't exist
     */

    @GetMapping("/{id}")
    public ResponseEntity<Travel> getTravelById(@PathVariable long id) {
        Travel travel=travelService.getTravelById(id);
        if(travel!=null) {
            return ResponseEntity.ok(travel);

        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Retrieves Travel by its Destination Name.
     *
     * @param name the Destination name of the Travel to search for
     * @return ResponseEntity containing the Travel with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if no Travel with the given name exists
     */

    @GetMapping("/byName")
    public ResponseEntity<Travel> getTravelByName(@RequestParam String name) {
        Travel travel=travelService.getTravelByName(name);
        if(travel!=null) {
            return ResponseEntity.ok(travel);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Deletes a specific Travel from the system.
     *
     * @param id the unique identifier of the Travel to delete
     * @return ResponseEntity with a success message and HTTP status 200 (OK) if deleted,
     * or an error message and HTTP status 404 (Not Found) if the Travel doesn't exist
     */

    //Delete - DELETE
    @DeleteMapping("/{byId}")
    public ResponseEntity<String> deleteTravel(@PathVariable long id) {
        boolean deleted=travelService.deleteTravel(id);
        if(deleted) {
            return ResponseEntity.ok("Travel deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Travel will not found ");
    }
}
