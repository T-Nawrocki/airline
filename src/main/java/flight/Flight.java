package flight;

import passenger.Passenger;
import plane.Plane;

import java.util.ArrayList;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private Airport destination;
    private Airport departureAirport;
    private String departureTime;

    public Flight(Plane plane, String flightNumber, Airport destination, Airport departureAirport, String departureTime) {
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public int numberOfPassengers() {
        return passengers.size();
    }

    public int availableSeats() {
        return plane.getCapacity() - numberOfPassengers();
    }
}
