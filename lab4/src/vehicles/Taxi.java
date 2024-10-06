package vehicles;

import people.Person;

public class Taxi<T extends Person> extends Car<T> {
    public Taxi(int passengersLimit) {
        super(passengersLimit);
    }
}
