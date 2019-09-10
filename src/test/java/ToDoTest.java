import Task.ToDo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {

    @Test
      void alwaysTrue () {
        assertEquals(2,2);
    }

    @Test
    public void dummyTest(){
        String input = "todo return library books";
        ToDo todo = new ToDo("return library books",false);
        assertEquals("return library books", todo.getInfo());
    }
}
