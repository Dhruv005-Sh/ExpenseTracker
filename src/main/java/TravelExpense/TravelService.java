package TravelExpense;

import java.util.List;

public interface TravelService {

    Travel createTravel(Travel travel) throws TravelValidationException;

    List<Travel> getAllTravels(Travel travel) throws TravelNotFoundException;

    Travel getTravelById(long id) throws TravelNotFoundException;

    Travel getTravelByName(String travelName) throws TravelNotFoundException;

    boolean deleteTravel(long id);

    List<Travel> getAllTravels();
}
