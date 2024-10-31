import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StaticArrayTest {

    private StaticArray staticArray;

    @BeforeEach
    public void setUp() {
        staticArray = new StaticArray(5); // Initialize StaticArray with size 5
    }

    @Test
    public void testInsert() {
        staticArray.insert(0, 10);
        staticArray.insert(1, 20);
        staticArray.insert(2, 30);
        assertEquals(10, staticArray.get(0));
        assertEquals(20, staticArray.get(1));
        assertEquals(30, staticArray.get(2));
    }

    @Test
    public void testInsertAtFullCapacity() {
        staticArray.insert(0, 10);
        staticArray.insert(1, 20);
        staticArray.insert(2, 30);
        staticArray.insert(3, 40);
        staticArray.insert(4, 50);

        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            staticArray.insert(5, 60); // This should throw an exception
        });

        assertEquals("Array is full", exception.getMessage());
    }

    @Test
    public void testDelete() {
        staticArray.insert(0, 10);
        staticArray.insert(1, 20);
        staticArray.insert(2, 30);
        staticArray.delete(1); // Remove the element at index 1 (20)

        assertEquals(10, staticArray.get(0));
        assertEquals(30, staticArray.get(1));
        assertEquals(0, staticArray.get(2)); // The last element should be reset to 0
    }

    @Test
    public void testDeleteInvalidIndex() {
        staticArray.insert(0, 10);
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            staticArray.delete(1); // This should throw an exception since only one element exists
        });

        assertEquals("Index out of bounds", exception.getMessage());
    }

    @Test
    public void testTraverse() {
        staticArray.insert(0, 10);
        staticArray.insert(1, 20);
        staticArray.insert(2, 30);

        // Capture the output from the traverse method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        staticArray.traverse();

        String expectedOutput = "10 20 30 \n";
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
