package vehicles;

import people.Person;

public class Car<T extends Person> extends Vehicle<T> {
    Car(int passengersLimit) {
        super(passengersLimit);
    }
}
