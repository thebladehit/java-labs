package vehicles;

import people.FireFighter;

public class Firetruck<T extends FireFighter> extends Car<T> {
    public Firetruck(int passengersLimit) {
        super(passengersLimit);
    }
}
