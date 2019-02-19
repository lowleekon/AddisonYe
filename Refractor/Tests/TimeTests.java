
import Tools.Clock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeTests {
    Clock clock;

    @Before
    public void setup(){
        clock = new Clock();
    }

    @Test
    public void testTick(){
        clock.Tick();
        assertEquals(1,clock.getSec());
        Clock clock2 = new Clock(10, 59, 59);
        clock2.Tick();
        assertEquals(11,clock2.getHour());
    }
}
