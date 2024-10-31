/*Test Cases for Static Array*/
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

/*Test Cases for Dynamic Array*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {

    private DynamicArray dynamicArray;

    @BeforeEach
    public void setUp() {
        dynamicArray = new DynamicArray(); // Initialize DynamicArray
    }

    @Test
    public void testInsert() {
        dynamicArray.insert(0, 10);
        dynamicArray.insert(1, 20);
        dynamicArray.insert(2, 30);

        assertEquals(10, dynamicArray.get(0));
        assertEquals(20, dynamicArray.get(1));
        assertEquals(30, dynamicArray.get(2));
    }

    @Test
    public void testInsertAtEnd() {
        dynamicArray.insert(0, 10);
        dynamicArray.insert(1, 20);
        dynamicArray.insert(2, 30);
        dynamicArray.insert(3, 40); // Inserting at the end

        assertEquals(40, dynamicArray.get(3));
    }

    @Test
    public void testInsertBeyondInitialCapacity() {
        for (int i = 0; i < 10; i++) {
            dynamicArray.insert(i, i * 10); // Insert values 0, 10, ..., 90
        }

        assertEquals(90, dynamicArray.get(9));
    }

    @Test
    public void testDelete() {
        dynamicArray.insert(0, 10);
        dynamicArray.insert(1, 20);
        dynamicArray.insert(2, 30);
        dynamicArray.delete(1); // Remove element at index 1 (20)

        assertEquals(10, dynamicArray.get(0));
        assertEquals(30, dynamicArray.get(1)); // The next element should shift left
    }

    @Test
    public void testDeleteInvalidIndex() {
        dynamicArray.insert(0, 10);
        dynamicArray.insert(1, 20);

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            dynamicArray.delete(2); // This should throw an exception since index 2 doesn't exist
        });

        assertEquals("Index out of bounds", exception.getMessage());
    }

    @Test
    public void testTraverse() {
        dynamicArray.insert(0, 10);
        dynamicArray.insert(1, 20);
        dynamicArray.insert(2, 30);

        // Capture the output from the traverse method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        dynamicArray.traverse();

        String expectedOutput = "10 20 30 \n";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    public void testResizeOnInsert() {
        // Inserting enough elements to trigger resize
        for (int i = 0; i < 15; i++) {
            dynamicArray.insert(i, i * 5); // Inserting elements
        }

        assertEquals(10, dynamicArray.get(2)); // Verify element exists after resizing
        assertEquals(70, dynamicArray.get(14)); // Verify last element after resizing
    }

    @Test
    public void testDeleteFromEmptyArray() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            dynamicArray.delete(0); // This should throw an exception since the array is empty
        });

        assertEquals("Index out of bounds", exception.getMessage());
    }
}

/*Test Cases for String Operations*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringOperationsTest {

    private StringOperations stringOps;

    @BeforeEach
    public void setUp() {
        stringOps = new StringOperations();
    }

    @Test
    public void testConcatenation() {
        String result = stringOps.concatenate("Hello, ", "World!");
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testSubstring() {
        String result = stringOps.substring("Hello, World!", 7, 12);
        assertEquals("World", result);
    }

    @Test
    public void testSubstringOutOfBounds() {
        Exception exception = assertThrows(StringIndexOutOfBoundsException.class, () -> {
            stringOps.substring("Hello, World!", 7, 15); // This should throw an exception
        });

        assertEquals("String index out of range: 15", exception.getMessage());
    }

    @Test
    public void testComparisonEqual() {
        int result = stringOps.compare("Hello", "Hello");
        assertEquals(0, result); // Expecting 0 for equal strings
    }

    @Test
    public void testComparisonNotEqual() {
        int result = stringOps.compare("Hello", "World");
        assertTrue(result < 0); // "Hello" is less than "World"
    }

    @Test
    public void testCharacterFrequency() {
        int[] frequency = stringOps.characterFrequency("Hello");
        assertEquals(1, frequency['H']);
        assertEquals(1, frequency['e']);
        assertEquals(2, frequency['l']);
        assertEquals(1, frequency['o']);
        assertEquals(0, frequency['W']); // Should be zero for characters not in the string
    }

    @Test
    public void testCharacterFrequencyEmptyString() {
        int[] frequency = stringOps.characterFrequency("");
        for (int count : frequency) {
            assertEquals(0, count); // Expecting all counts to be zero for empty string
        }
    }

    @Test
    public void testCharacterFrequencyWithSpaces() {
        int[] frequency = stringOps.characterFrequency("Hello World");
        assertEquals(1, frequency['H']);
        assertEquals(1, frequency['e']);
        assertEquals(3, frequency['l']);
        assertEquals(2, frequency['o']);
        assertEquals(1, frequency['W']);
        assertEquals(1, frequency['r']);
        assertEquals(1, frequency['d']);
        assertEquals(0, frequency['x']); // Should be zero for characters not in the string
    }
}
