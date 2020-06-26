package test.shitikov.task4_1.service;

import com.shitikov.task4_1.entity.CustomArray;
import com.shitikov.task4_1.exception.ProjectException;
import com.shitikov.task4_1.service.ArraySortService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ArraySortServiceTest {
    ArraySortService service;

    @BeforeMethod
    public void setUp() {
        service = new ArraySortService();
    }

    @DataProvider(name = "customArrays")
    public Object[][] createCustomArrays() {
        int[] arr1 = new int[]{1, 6, 5, 4, 10};
        int[] arr2 = new int[]{0, 34, 21, 32, 14};

        int[] sortArr1 = new int[]{1, 4, 5, 6, 10};
        int[] sortArr2 = new int[]{0, 14, 21, 32, 34};

        CustomArray cArray1 = new CustomArray(arr1);
        CustomArray cArray2 = new CustomArray(arr2);

        CustomArray cArraySort1 = new CustomArray(sortArr1);
        CustomArray cArraySort2 = new CustomArray(sortArr2);

        return new Object[][]{{cArray1, cArraySort1}, {cArray2, cArraySort2}};
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testSortSelectionException() throws ProjectException {
        service.sortSelection(null);
    }

    @Test(dataProvider = "customArrays")
    public void testSortSelection(CustomArray actual, CustomArray expected) {
        try {
            service.sortSelection(actual);
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testSortShellException() throws ProjectException {
        service.sortShell(null);
    }

    @Test(dataProvider = "customArrays")
    public void testSortShell(CustomArray actual, CustomArray expected) {
        try {
            service.sortShell(actual);
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testSortInsertionException() throws ProjectException {
        service.sortInsertion(null);
    }

    @Test(dataProvider = "customArrays")
    public void testSortInsertion(CustomArray actual, CustomArray expected) {
        try {
            service.sortInsertion(actual);
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }
}