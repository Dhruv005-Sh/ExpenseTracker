package TravelExpense;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryTravelService implements TravelService {
    private final List<Travel> travels;
    public InMemoryTravelService() {
        travels = new ArrayList<>();
    }

    @Override
    public Travel createTravel(Travel travel)  {
        travels.add(travel);
        return travel;
    }

    @Override
    public List<Travel> getAllTravels(Travel travel) {
        return travels;
    }

    @Override
    public Travel getTravelById(long id) {
        for (Travel travel : travels) {
            if (travel.getId() == id) {
                return travel;
            }
        }
        return null;
    }

    @Override
    public Travel getTravelByName(String travelName) {
        for (Travel travel : travels) {
            if (travel.getDestinationname().equals(travelName)) {
                return travel;
            }
        }
        return null;
    }

    @Override
    public boolean deleteTravel(long id) {
        Travel travel = getTravelById(id);
        if (travel != null) {
            travels.remove(travel);
            return true;
        }
        return false;
    }

    @Override
    public List<Travel> getAllTravels() {
        return List.of();
    }
}
