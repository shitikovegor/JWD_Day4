package test.shitikov.task4_1.reader;

import com.shitikov.task4_1.exception.ProjectException;
import com.shitikov.task4_1.reader.CustomArrayReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CustomArrayReaderTest {
    CustomArrayReader reader;

    @BeforeMethod
    public void setUp() {
        reader = new CustomArrayReader();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testReadFileException() {
        reader.readFile("resources/exception_test_file.txt");
    }

    @Test
    public void testReadFilePositive() {
        List<String> actual = reader.readFile("resources/test_file.txt");
        List<String> expected = new ArrayList<>();
        expected.add("25 536 451 12");
        assertEquals(actual, expected, "Test failed as... ");
    }

    @Test
    public void testReadFileNegative() {
        List<String> actual = reader.readFile("resources/test_file.txt");
        List<String> expected = new ArrayList<>();
        expected.add("2 5 1 3 12");

        assertNotEquals(actual, expected, "Test failed as... ");
    }

    @Test
    public void testReadConsolePositive() {
        try {
            String expected = "23 65 48 211";

            InputStream input = new ByteArrayInputStream(expected.getBytes());
            System.setIn(input);
            String actual = reader.readConsole();
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testReadConsoleNegative() {
        try {
            String consoleInput = "12 26 21 68;";
            InputStream input = new ByteArrayInputStream(consoleInput.getBytes());
            System.setIn(input);
            String actual = reader.readConsole();
            String expected = "23 65 48 211";

            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }
}