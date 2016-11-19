import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by himanshu on 10/19/16.
 */
public class BinarySearchTest {

    public class TestCase{
        int[] arr;
        int searchFor;
        int expected;
        public TestCase(int [] a, int s, int e){
            arr = a;
            searchFor = s;
            expected =e;
        }

    }
    @Test
    public void binarySearch() throws Exception {
        TestCase[] tests = {
                new TestCase(new int[]{1, 2, 3}, 1, 0),
                new TestCase(new int[]{1, 2, 3}, 2, 1),
                new TestCase(new int[]{1, 2, 3}, 3, 2),
                new TestCase(new int[]{1, 2, 3}, 0, -1),
                new TestCase(new int[]{1, 2, 3}, 4, -1),
                new TestCase(new int[]{}, 1, -1),
                new TestCase(new int[]{1}, 1, 0),
                new TestCase(new int[]{1}, 4, -1),
                new TestCase(new int[]{3,5,6,64,255,1312,43534,54654,23445345,999999999},444345345, -1),
                new TestCase(new int[]{1,5,6,7,7,7,8}, 7, 3),
        };

        for(TestCase t: tests){
            int actual = BinarySearch.binarySearch(t.arr, t.searchFor);
            String err = "";
            err += t.arr;
            err += ", searchfor="+t.searchFor;

            assertEquals(err, t.expected, actual);
        }


    }

}