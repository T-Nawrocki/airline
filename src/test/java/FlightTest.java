import flight.Airport;
import flight.Flight;
import org.junit.Before;
import org.junit.Test;
import passenger.Passenger;
import plane.Plane;
import plane.PlaneType;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FlightTest {

    private Flight flight;
    private Plane plane;
    private Passenger passenger;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING_737);
        flight = new Flight(
                plane, "AB123",
                Airport.ARN,
                Airport.EDI,
                2020,
                11,
                24,
                11,
                30);
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
        assertEquals(
                ZonedDateTime.of(2020, 11, 24, 11, 30, 0, 0, ZoneId.of("Europe/London")),
                flight.getDepartureTime());
    }

    @Test
    public void hasAvailableSeats() {
        ArrayList<Integer> expected = new ArrayList<Integer>() {{
                for (int i = 1; i <= flight.getPlane().getCapacity(); i++) {
                    add(i);
                }
            }};
        assertEquals(expected, flight.getAvailableSeats());
    }

    @Test
    public void passengersStartsEmpty() {
        assertEquals(0, flight.numberOfPassengers());
    }

    @Test
    public void canGetNumberOfAvailableSeats() {
        assertEquals(175, flight.numberOfAvailableSeats());
    }

    @Test
    public void canBookPassengerOnFlightIfThereAreAvailableSeats() {
        flight.book(passenger);

        assertEquals(1, flight.numberOfPassengers());
        assertEquals(flight, passenger.getFlight());

        ArrayList<Integer> expectedAvailableSeats = new ArrayList<Integer>() {{
            for (int i = 1; i <= flight.getPlane().getCapacity(); i++) {
                add(i);
            }
        }};
        expectedAvailableSeats.remove(expectedAvailableSeats.indexOf(passenger.getSeat()));
        assertEquals(expectedAvailableSeats, flight.getAvailableSeats());
    }

    @Test
    public void cannotBookPassengerOnFightIfThereAreNoSeatsLeft() {
        Plane paperAeroplane = new Plane(PlaneType.PAPER_AEROPLANE);
        Flight paperFlight = new Flight(
                paperAeroplane,
                "CD456",
                Airport.EDI,
                Airport.EDI,
                2020,
                9,
                13,
                10,
                0);
        paperFlight.book(passenger);
        assertEquals(0, paperFlight.numberOfPassengers());
    }


}
