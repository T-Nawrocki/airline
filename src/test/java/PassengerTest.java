import org.junit.Before;
import org.junit.Test;
import passenger.Passenger;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger("Jen", 3);
    }

    @Test
    public void hasName() {
        assertEquals("Jen", passenger.getName());
    }

    @Test
    public void hasBags() {
        assertEquals(3, passenger.getBags());
    }

}
