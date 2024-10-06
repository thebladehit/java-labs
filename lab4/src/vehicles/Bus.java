package vehicles;


import people.Person;

public class Bus<T extends Person> extends Vehicle<T> {
    public Bus(int passengersLimit) {
        super(passengersLimit);
    }
}
