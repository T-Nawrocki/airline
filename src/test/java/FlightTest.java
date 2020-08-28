import flight.Airport;
import flight.Flight;
import org.junit.Before;
import org.junit.Test;
import passenger.Passenger;
import plane.Plane;
import plane.PlaneType;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FlightTest {

    private Flight flight;
    private Plane plane;
    private Passenger passenger;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING_737);
        flight = new Flight(plane, "AB123", Airport.ARN, Airport.EDI, "16:30");
        passenger = new Passenger("Jen", 3);
    }

    @Test
    public void hasPassengers() {
        assertEquals(new ArrayList<Passenger>(), flight.getPassengers());
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
    public void hasDepartureTime() {
        assertEquals("16:30", flight.getDepartureTime());
    }

    @Test
    public void passengersStartsEmpty() {
        assertEquals(0, flight.numberOfPassengers());
    }

    @Test
    public void canGetNumberOfAvailableSeats() {
        assertEquals(175, flight.availableSeats());
    }

    @Test
    public void canBookPassengerOnFlightIfThereAreAvailableSeats() {
        flight.book(passenger);
        assertEquals(1, flight.numberOfPassengers());
    }

    @Test
    public void cannotBookPassengerOnFightIfThereAreNoSeatsLeft() {
        Plane paperAeroplane = new Plane(PlaneType.PAPER_AEROPLANE);
        Flight paperFlight = new Flight(paperAeroplane, "CD456", Airport.EDI, Airport.EDI, "10:00");
        paperFlight.book(passenger);
        assertEquals(0, paperFlight.numberOfPassengers());
    }


}
