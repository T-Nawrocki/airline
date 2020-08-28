import flight.Airport;
import flight.Flight;
import org.junit.Before;
import org.junit.Test;
import passenger.Passenger;
import plane.Plane;
import plane.PlaneType;

import static flight.FlightManager.baggageAllocationPerPassenger;
import static flight.FlightManager.currentBaggageLoad;
import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private Flight flight;
    private Plane plane;
    private Passenger passenger;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING_737);
        flight = new Flight(plane, "AB123", Airport.ARN, Airport.EDI, "16:30");
        passenger = new Passenger("Jen", 150);
    }

    @Test
    public void canGetBaggageAllocationPerPassenger() {
        assertEquals(228, baggageAllocationPerPassenger(flight));
    }

    @Test
    public void canGetCurrentBaggageLoad() {
        flight.book(passenger);
        assertEquals(150, currentBaggageLoad(flight));
    }

}
