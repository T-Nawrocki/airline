import flight.Airport;
import flight.Flight;
import org.junit.Before;
import org.junit.Test;
import passenger.Passenger;
import plane.Plane;
import plane.PlaneType;

import static flight.FlightManager.*;
import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private Flight flight;
    private Plane plane;
    private Passenger passenger;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING_737);
        flight = new Flight(
                plane,
                "AB123",
                Airport.ARN,
                Airport.EDI,
                2020,
                11,
                24,
                11,
                30);
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

    @Test
    public void canGetRemainingBaggageCapacity() {
        flight.book(passenger);
        assertEquals(39850, remainingBaggageCapacity(flight));
    }

}
