package duke.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ToDoTest {
    @Test
    public void addToDoTest() {
        ToDo toDo = new ToDo("ToDo 1");
        assertEquals("[T][ ] ToDo 1", toDo.toString());
    }

    @Test
    public void saveToDoTest() {
        ToDo toDo = new ToDo("ToDo 1");
        assertEquals("T |   | ToDo 1", toDo.stringify());
    }
}
