package flight;

import plane.Plane;

public class FlightManager {

    private FlightManager() {}  // prevents class from being instantiated

    public static int baggageAllocationPerPassenger(Flight flight) {
        Plane plane = flight.getPlane();
        return plane.maxBaggageWeight() / plane.getCapacity();  // truncates decimal places
    }

    public static int currentBaggageLoad(Flight flight) {
        return flight.getPassengers()
                .stream()  // converts to Stream (class which provides collection manipulation tools)
                .reduce(0,  // initial value of accumulator
                        (acc, passenger) -> acc + passenger.getBagWeight(),  // reduction lambda
                        Integer::sum);  // combiner—dictates accumulator arg types, prevents clash with int + Passenger
    }

    public static int remainingBaggageCapacity(Flight flight) {
        Plane plane = flight.getPlane();
        return plane.maxBaggageWeight() - currentBaggageLoad(flight);
    }

}
