import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    private void before() {
        passenger = new Passenger("Jen", 3);
    }

    @Test
    private void hasName() {
        assertEquals("Jen", passenger.getName());
    }

    @Test
    private void hasBags() {
        assertEquals(3, getBags());
    }

}
