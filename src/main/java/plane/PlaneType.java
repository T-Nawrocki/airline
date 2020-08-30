package plane;

public enum PlaneType {

    AIRBUS_A320(150, 70000),
    BOEING_737(175, 80000),
    BOEING_777(400, 300000),
    PAPER_AEROPLANE(0, 1);

    private final int capacity;
    private final int maxWeight;

    PlaneType(int capacity, int maxWeight) {
        this.capacity = capacity;
        this.maxWeight = maxWeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}
