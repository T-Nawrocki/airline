package flight;

import passenger.Passenger;
import plane.Plane;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private Airport destination;
    private Airport departureAirport;
    private ZonedDateTime departureTime;

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

    public int numberOfPassengers() {
        return passengers.size();
    }

    public int availableSeats() {
        return plane.getCapacity() - numberOfPassengers();
    }


    public void book(Passenger passenger) {
        if (availableSeats() > 0) passengers.add(passenger);
    }
}
