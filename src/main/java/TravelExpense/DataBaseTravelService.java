package TravelExpense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import javax.print.attribute.standard.Destination;
import java.util.List;

/**
 * A service that uses a database to store and manage Travel information.
 * This class implements the TravelService interface and uses a TravelRepository
 * to perform operations on the database.
 */

@Service
public class DataBaseTravelService implements TravelService {

    /**
     * The repository used to access the database.
     */
    private final TravelRepository travelRespository;


    /**
     * Creates a new DatabaseTravelService with the provided repository.
     *
     * @param travelRespository the repository to use for database operations
     */
    @Autowired
    public DataBaseTravelService(TravelRepository travelRespository) {
        this.travelRespository = travelRespository;
    }

    /**
     * Adds a new travel to the database.
     *
     * @param travel the travel to add
     * @return the saved travel with any database-generated values (like ID)
     */
    @Override
    public Travel createTravel(Travel travel) {
        if (travel == null) {
            throw new TravelValidationException("Travel is null");
        }
        return travelRespository.save(travel);
    }

    /**
     * Gets a list of all Travel from the database.
     *
     * @return a list containing all Travels
     */
    @Override
    public List<Travel> getAllTravels(Travel travel){
        List<Travel> travelList = travelRespository.findAll();
        if (travelList.isEmpty()) {
            throw new TravelValidationException("No Travel found");
        }
        return travelRespository.findAll();
    }



    /**
     * Finds a travel in the database using its ID.
     *
     * @param id the ID of the travel to find
     * @return the found travel, or null if no travel exists with the given ID
     */

    @Override
    public Travel getTravelById(long id) {
        return travelRespository.findById(id)
                .orElseThrow(() -> new TravelNotFoundException("Travel with id " + id + " not found"));
    }

    /**
     * Finds a travel in the database using its Destination name.
     *
     * @param travelName the Destination name of the Travel to find
     * @return the found Travel or null if no Travel exists with the given name
     */

    @Override
    public Travel getTravelByName(String travelName)  {
        return travelRespository.findByTravelName(travelName)
                .orElseThrow(() -> new TravelNotFoundException("Travel with name" + travelName + "not found"));
    }

    /**
     * Deletes a travel from the database.
     *
     * @param id the ID of the travel to delete
     * @return true if a travel was deleted, false if no travel exists with the given ID
     */

    @Override
    public boolean deleteTravel(long id) {
        if (travelRespository.existsById(id)) {
            travelRespository.deleteById(id);
            return true;
        }else
        {throw new TravelNotFoundException("Travel with id " + id + " not found");}
    }

    @Override
    public List<Travel> getAllTravels() {
        return List.of();
    }
}
