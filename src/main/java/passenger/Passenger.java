package passenger;

import flight.Flight;

public class Passenger {

    private final String name;
    private final int bagWeight;
    private Flight flight;
    private int seat;

    public Passenger(String name, int bagWeight) {
        this.name = name;
        this.bagWeight = bagWeight;
    }

    public String getName() {
        return name;
    }

    public int getBagWeight() {
        return bagWeight;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getSeat() {
        return seat;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
