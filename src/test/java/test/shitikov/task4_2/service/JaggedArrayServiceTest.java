package test.shitikov.task4_2.service;

import com.shitikov.task4_1.exception.ProjectException;
import com.shitikov.task4_2.comparator.MaxComparator;
import com.shitikov.task4_2.comparator.MinComparator;
import com.shitikov.task4_2.comparator.SumComparator;
import com.shitikov.task4_2.enumeration.SortingOrder;
import com.shitikov.task4_2.service.JaggedArrayService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Comparator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class JaggedArrayServiceTest {
    JaggedArrayService service;
    int[][] actual;

    @BeforeMethod
    public void setUp() {
        service = new JaggedArrayService();
        actual = new int[][]{{0, 6}, {2, 3, 5}, {4, 2, 1}};
    }

    @DataProvider(name = "exceptionData")
    public Object[][] createExceptionData() {
        return new Object[][]{{null, new MaxComparator(), SortingOrder.DECREASE},
                {actual, null, SortingOrder.INCREASE},
                {actual, new MinComparator(), null}};
    }

    @Test(dataProvider = "exceptionData", expectedExceptions = ProjectException.class)
    public void testSortBubbleException(int[][] arrayForSort, Comparator<int[]> comparator, SortingOrder sortingOrder) throws ProjectException {
        service.sortBubble(arrayForSort, comparator, sortingOrder);
    }

    @Test
    public void testSortBubbleMaxDecrease() {
        try {
            service.sortBubble(actual, new MaxComparator(), SortingOrder.DECREASE);
            int[][] expected = new int[][]{{4, 2, 1}, {2, 3, 5}, {0, 6}};
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testSortBubbleMaxIncrease() {
        try {
            service.sortBubble(actual, new MaxComparator(), SortingOrder.INCREASE);
            int[][] expected = new int[][]{{0, 6}, {2, 3, 5}, {4, 2, 1}};
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testSortBubbleMinDecrease() {
        try {
            service.sortBubble(actual, new MinComparator(), SortingOrder.DECREASE);
            int[][] expected = new int[][]{{0, 6}, {4, 2, 1}, {2, 3, 5}};
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testSortBubbleMinIncrease() {
        try {
            service.sortBubble(actual, new MinComparator(), SortingOrder.INCREASE);
            int[][] expected = new int[][]{{2, 3, 5}, {4, 2, 1}, {0, 6}};
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testSortBubbleSumDecrease() {
        try {
            service.sortBubble(actual, new SumComparator(), SortingOrder.DECREASE);
            int[][] expected = new int[][]{{0, 6}, {4, 2, 1}, {2, 3, 5}};
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testSortBubbleSumIncrease() {
        try {
            service.sortBubble(actual, new SumComparator(), SortingOrder.INCREASE);
            int[][] expected = new int[][]{{2, 3, 5}, {4, 2, 1}, {0, 6}};
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }
}