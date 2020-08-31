import flight.Airport;
import flight.Flight;
import org.junit.Before;
import org.junit.Test;
import passenger.Passenger;
import plane.Plane;
import plane.PlaneType;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger("Jen", 3);
    }

    @Test
    public void hasName() {
        assertEquals("Jen", passenger.getName());
    }

    @Test
    public void hasBagWeight() {
        assertEquals(3, passenger.getBagWeight());
    }

    @Test
    public void canSetFlight() {
        Plane plane = new Plane(PlaneType.BOEING_737);
        Flight flight = new Flight(
                plane,
                "AB123",
                Airport.ARN,
                Airport.EDI,
                2020,
                11,
                24,
                11,
                30);

        passenger.setFlight(flight);
        assertEquals(flight, passenger.getFlight());
    }

    @Test
    public void canSetSeat() {
        passenger.setSeat(1);
        assertEquals(1, passenger.getSeat());
    }

}
