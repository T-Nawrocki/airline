package passenger;

public class Passenger {

    private String name;
    private int bagWeight;

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
}
