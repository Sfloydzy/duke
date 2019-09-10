import Task.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {


    @Test
    public void alwaysTrue () {
        assertEquals(2,2);
    }

    @Test
    public void dummyTest(){
       Event event = new Event("return stuff", false, "2/12/2019 1800");
        assertEquals("return stuff", event.getInfo());
        assertEquals("2/12/2019 1800", event.getDate());
    }
}
