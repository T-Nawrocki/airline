import flight.Airport;
import flight.Flight;
import org.junit.Before;
import org.junit.Test;
import plane.Plane;
import plane.PlaneType;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Flight flight;
    private Plane plane;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING_737);
        flight = new Flight(plane, "AB123", Airport.ARN, Airport.EDI, "16:30");
    }

    @Test
    public void passengersStartsEmpty() {
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    public void hasPlane() {
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("AB123", flight.getFlightNumber());
    }

    @Test
    public void hasDestination() {
        assertEquals(Airport.ARN, flight.getDestination());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals(Airport.EDI, flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureeTime() {
        assertEquals("16:30", flight.getDepartureTime());
    }

}
