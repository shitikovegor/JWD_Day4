package test.shitikov.task4_1.parser;

import com.shitikov.task4_1.entity.CustomArray;
import com.shitikov.task4_1.exception.ProjectException;
import com.shitikov.task4_1.parser.CustomArrayParser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomArrayParserTest {
    CustomArrayParser parser = new CustomArrayParser();
    int[] testArrayTrue;
    int[] testArrayFalse;

    @BeforeMethod
    public void setUp() {
        parser = new CustomArrayParser();
        testArrayTrue = new int[]{25, 536, 451, 12};
        testArrayFalse = new int[]{20, 21, 1, 234};
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testParseArrayException() throws ProjectException {
        parser.parseArray("sds 123 123.0");
    }

    @DataProvider(name = "data")
    public Object[] createData() {
        return new Object[]{"25, 536, 451, 12", "25 536 451 12", "[25 536 451 12]"};
    }

    @Test(dataProvider = "data")
    public void testParseArrayPositive(String arrayString) {
        try {
            CustomArray actual = parser.parseArray(arrayString);
            CustomArray expected = new CustomArray(testArrayTrue);
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testParseArrayNegative() {
        try {
            CustomArray actual = parser.parseArray("1 23 544 1243");
            CustomArray expected = new CustomArray(testArrayFalse);
            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }
}