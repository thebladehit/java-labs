package roads;

import people.Person;
import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Vehicle<? extends Person>> carsInRoad = new ArrayList<>();

    public int getCountOfHumans() {
        int count = 0;
        for (Vehicle<? extends Person> vehicle : carsInRoad) {
            count += vehicle.getPassengersCount();
        }
        return count;
    }

    public void addCarToRoad(Vehicle<? extends Person> vehicle) {
        carsInRoad.add(vehicle);
    }
}
