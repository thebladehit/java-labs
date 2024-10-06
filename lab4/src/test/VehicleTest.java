package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import people.FireFighter;
import people.Person;
import people.PersonType;
import people.PoliceMan;
import roads.Road;
import vehicles.*;

public class VehicleTest {
    private Vehicle<FireFighter> fireTruck;
    private Vehicle<PoliceMan> policeManVehicle;
    private Vehicle<Person> taxi;
    private final Road road = new Road();

    @Before
    public void setUp() throws Exception {
        fireTruck = new Firetruck<>(3);
        policeManVehicle = new Police<>(4);
        taxi = new Taxi<>(4);

        road.addCarToRoad(fireTruck);
        road.addCarToRoad(policeManVehicle);
        road.addCarToRoad(taxi);

        for (int i = 0; i < 4; i++) {
            try {
                policeManVehicle.seatInVehicle(new PoliceMan("Sam", PersonType.POLICEMAN));
                taxi.seatInVehicle(new PoliceMan("Dwayne", PersonType.FIREFIGHTER));
                fireTruck.seatInVehicle(new FireFighter("John", PersonType.FIREFIGHTER));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Test
    public void getVehiclePassengersCount() {
        assertEquals(3, fireTruck.getPassengersCount());
        assertEquals(4, taxi.getPassengersCount());
        assertEquals(4, policeManVehicle.getPassengersCount());
    }

    @Test
    public void getRoadPassengersCount() {
        assertEquals(11, road.getCountOfHumans());
    }

    @Test
    public void seatAndOutPassenger() throws Exception {
        Vehicle<PoliceMan> vehicle = new Police<>(4);
        assertEquals(0, vehicle.getPassengersCount());

        PoliceMan person = new PoliceMan("Sam", PersonType.POLICEMAN);
        vehicle.seatInVehicle(person);
        assertEquals(1, vehicle.getPassengersCount());

        vehicle.seatOutVehicle(person);
        assertEquals(0, vehicle.getPassengersCount());
    }
}