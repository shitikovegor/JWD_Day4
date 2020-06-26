package test.shitikov.task4_1.creator;

import com.shitikov.task4_1.creator.CustomArrayCreator;
import com.shitikov.task4_1.entity.CustomArray;
import com.shitikov.task4_1.exception.ProjectException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomArrayCreatorTest {
    CustomArrayCreator creator;
    int[] testArrayTrue;
    int[] testArrayFalse;

    @BeforeMethod
    public void setUp() {
        creator = new CustomArrayCreator();
        testArrayTrue = new int[]{25, 536, 451, 12};
        testArrayFalse = new int[]{20, 21, 1, 234};
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testCreateArrayFromFileException() throws ProjectException {
        creator.createArrayFromFile("test_file.exe");
    }

    @Test
    public void testCreateArrayFromFilePositive() {
        try {
            CustomArray actual = creator.createArrayFromFile("resources/test_file.txt");
            CustomArray expected = new CustomArray(testArrayTrue);
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testCreateArrayFromFileNegative() {
        try {
            CustomArray actual = creator.createArrayFromFile("resources/test_file.txt");
            CustomArray expected = new CustomArray(testArrayFalse);
            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testCreateArrayFromStringException() throws ProjectException {
        creator.createArrayFromString("sd se 12 c");
    }

    @Test
    public void testCreateArrayFromStringPositive() {
        try {
            CustomArray actual = creator.createArrayFromString("25 536 451 12");
            CustomArray expected = new CustomArray(testArrayTrue);
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testCreateArrayFromStringNegative() {
        try {
            CustomArray actual = creator.createArrayFromString("25 536 451 12");
            CustomArray expected = new CustomArray(testArrayFalse);
            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }
}