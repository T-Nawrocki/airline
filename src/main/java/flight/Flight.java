package flight;

import passenger.Passenger;
import plane.Plane;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Flight {

    private final ArrayList<Passenger> passengers;
    private final Plane plane;
    private final String flightNumber;
    private final Airport destination;
    private final Airport departureAirport;
    private final ZonedDateTime departureTime;
    private final ArrayList<Integer> availableSeats;

    public Flight(
            Plane plane,
            String flightNumber,
            Airport destination,
            Airport departureAirport,
            int departureYear,
            int departureMonth,
            int departureDay,
            int departureHour,
            int departureMinute
    ) {
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = ZonedDateTime.of(
                departureYear, departureMonth, departureDay,
                departureHour, departureMinute, 0, 0,
                ZoneId.of("Europe/London"));
        this.availableSeats = new ArrayList<Integer>() {{
            for (int i = 1; i <= plane.getCapacity(); i++) {
                add(i);
            }
        }};
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getDestination() {
        return destination;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public ZonedDateTime getDepartureTime() {
        return departureTime;
    }

    public ArrayList<Integer> getAvailableSeats() {
        return availableSeats;
    }

    public int numberOfPassengers() {
        return passengers.size();
    }

    public int numberOfAvailableSeats() {
        return getAvailableSeats().size();
    }

    public int randomAvailableSeatIndex() {
        Random random = new Random();
        return random.ints(0, numberOfAvailableSeats()).findFirst().getAsInt();
    }

    public void book(Passenger passenger) {
        if (numberOfAvailableSeats() > 0) {
            passengers.add(passenger);

            int seatIndex = randomAvailableSeatIndex();
            int seat = availableSeats.get(seatIndex);

            passenger.setFlight(this);
            passenger.setSeat(seat);

            availableSeats.remove(seatIndex);
        }
    }
}
