package vehicles;

import people.Person;

import java.util.ArrayList;

public class Vehicle<T extends Person> {
    protected int passengersLimit;
    protected ArrayList<T> passengers = new ArrayList<>();

    public Vehicle(int passengersLimit) {
        this.passengersLimit = passengersLimit;
    }

    public int getPassengersLimit() {
        return passengersLimit;
    }

    public int getPassengersCount() {
        return passengers.size();
    }

    public void seatInVehicle(T passenger) throws Exception {
        if (passengers.size() >= passengersLimit) {
            throw new Exception("No free space");
        }
        passengers.add(passenger);
    }

    public void seatOutVehicle(T passenger) throws Exception {
        if (!passengers.contains(passenger)) {
            throw new Exception("No such passenger");
        }
        passengers.remove(passenger);
    }
}
