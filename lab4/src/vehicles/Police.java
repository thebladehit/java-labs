package vehicles;

import people.PoliceMan;

public class Police<T extends PoliceMan> extends Car<T> {
    public Police(int passengersLimit) {
        super(passengersLimit);
    }
}
