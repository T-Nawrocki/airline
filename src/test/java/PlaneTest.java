import org.junit.Before;
import org.junit.Test;
import plane.Plane;
import plane.PlaneType;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void before() {
        plane = new Plane(PlaneType.AIRBUS_A320);
    }

    @Test
    public void hasType() {
        assertEquals(PlaneType.AIRBUS_A320, plane.getType());
    }

    @Test
    public void hasCapacity() {
        assertEquals(150, plane.getCapacity());
    }

    @Test
    public void hasMaxWeight() {
        assertEquals(70000, plane.getMaxWeight());
    }

    @Test
    public void canGetMaxBaggageWeight() {
        assertEquals(35000, plane.maxBaggageWeight());
    }

}
