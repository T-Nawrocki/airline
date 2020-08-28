package flight;

import plane.Plane;

public class FlightManager {

    private FlightManager() {};  // prevents class from being instantiated

    public static int baggageAllocationPerPassenger(Flight flight) {
        Plane plane = flight.getPlane();
        return plane.maxBaggageWeight() / plane.getCapacity();  // truncates decimal places
    }

}
