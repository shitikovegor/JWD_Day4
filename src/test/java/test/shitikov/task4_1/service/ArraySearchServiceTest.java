package test.shitikov.task4_1.service;

import com.shitikov.task4_1.entity.CustomArray;
import com.shitikov.task4_1.exception.ProjectException;
import com.shitikov.task4_1.service.ArraySearchService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySearchServiceTest {
    ArraySearchService service;

    @BeforeMethod
    public void setUp() {
        service = new ArraySearchService();
    }

    @DataProvider(name = "customArrays")
    public Object[] createCustomArrays() {
        int[] sortArr1 = new int[]{1, 5, 6, 9, 10};
        int[] sortArr2 = new int[]{0, 12, 21, 32, 56};
        int[] unsortArr1 = new int[]{10, 56, 124, 112, 96};
        int[] unsortArr2 = new int[]{231, 155, 55, 43, 85};

        CustomArray cArray1 = new CustomArray(sortArr1);
        CustomArray cArray2 = new CustomArray(sortArr2);
        CustomArray cArray3 = new CustomArray(unsortArr1);
        CustomArray cArray4 = new CustomArray(unsortArr2);

        return new Object[]{cArray1, cArray2, cArray3, cArray4};
    }

    @DataProvider(name = "searchSortArr")
    public Object[][] createSearchData() {
        Object[] customArrays = createCustomArrays();
        return new Object[][]{{customArrays[0], 1, 5, 10, 4},
                {customArrays[1], -2, 12, 32, 3}};
    }


    @Test(expectedExceptions = ProjectException.class)
    public void testBinarySearchException() throws ProjectException {
        service.binarySearch(null, 1, 4, 5);
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testBinarySearchSortException() throws ProjectException {
        int[] unsorted = new int[] {2, 5, 4, 1};
        CustomArray customArray = new CustomArray(unsorted);
        service.binarySearch(customArray, 1, 4, 5);
    }

    @Test(dataProvider = "searchSortArr")
    public void testBinarySearchPositive(CustomArray customArray, int start, int end, int numberToSearch, int index) {
        try {
            int actual = service.binarySearch(customArray, start, end, numberToSearch);
            int expected = index;
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(dataProvider = "searchSortArr")
    public void testBinarySearchNegative(CustomArray customArray, int start, int end, int numberToSearch, int index) {
        try {
            int actual = service.binarySearch(customArray, start, end, numberToSearch);
            int expected = 11;
            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testMaxValueException() throws ProjectException {
        service.maxValue(null);
    }

    @DataProvider(name = "maxMinData")
    public Object[][] createMaxData() {
        Object[] customArrays = createCustomArrays();
        return new Object[][]{{customArrays[0], 10, 1}, {customArrays[1], 56, 0},
                {customArrays[2], 124, 10}, {customArrays[3], 231, 43}};
    }

    @Test(dataProvider = "maxMinData")
    public void testMaxValuePositive(CustomArray customArray, int max, int min) {
        try {
            int actual = service.maxValue(customArray);
            int expected = max;
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(dataProvider = "maxMinData")
    public void testMaxValueNegative(CustomArray customArray, int max, int min) {
        try {
            int actual = service.maxValue(customArray);
            int expected = max - 1;
            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testMinValueException() throws ProjectException {
        service.minValue(null);
    }

    @Test(dataProvider = "maxMinData")
    public void testMinValuePositive(CustomArray customArray, int max, int min) {
        try {
            int actual = service.minValue(customArray);
            int expected = min;
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(dataProvider = "maxMinData")
    public void testMinValueNegative(CustomArray customArray, int max, int min) {
        try {
            int actual = service.minValue(customArray);
            int expected = min + 1;
            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testPrimeNumbersException() throws ProjectException {
        service.primeNumbers(null);
    }

    @Test
    public void testPrimeNumbersPositive() {
        try {
            int[] actual = service.primeNumbers(new CustomArray(new int[]{3, 7, 12, 17}));
            int[] expected = new int[]{3, 7, 17};
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testPrimeNumbersNegative() {
        try {
            int[] actual = service.primeNumbers(new CustomArray(new int[]{3, 7, 12, 17}));
            int[] expected = new int[]{3, 7};
            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testFibonacciNumbersException() throws ProjectException {
        service.fibonacciNumbers(null);
    }

    @Test
    public void testFibonacciNumbersPositive() {
        try {
            int[] actual = service.fibonacciNumbers(new CustomArray(new int[]{5, 8, 12, 21}));
            int[] expected = new int[]{5, 8, 21};
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testFibonacciNumbersNegative() {
        try {
            int[] actual = service.fibonacciNumbers(new CustomArray(new int[]{5, 8, 1500, 21}));
            int[] expected = new int[]{12};
            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testThreeDigitNumbersException() throws ProjectException {
        service.threeDigitNumbers(null);
    }

    @Test
    public void testThreeDigitNumbersPositive() {
        try {
            int[] actual = service.threeDigitNumbers(new CustomArray(new int[]{123, 4, 45, 112, 258}));
            int[] expected = new int[]{123, 258};
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testThreeDigitNumbersNegative() {
        try {
            int[] actual = service.threeDigitNumbers(new CustomArray(new int[]{123, 4, 45, 1112, 258}));
            int[] expected = new int[]{123, 1112};
            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }
}