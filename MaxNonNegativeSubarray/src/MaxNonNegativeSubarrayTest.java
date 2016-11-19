import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by himanshu on 8/28/16.
 */
public class MaxNonNegativeSubarrayTest {

    public ArrayList<Integer> arrToList(int [] arr){
        ArrayList<Integer> out = new ArrayList<Integer>();
        for(int i:arr)
            out.add(i);
        return out;
    }

    public void assertListEquals(ArrayList<Integer> expected, ArrayList<Integer> actual){
        assertEquals(expected.size(), actual.size());
        for(int i=0;i<expected.size();i++)
            assertEquals(expected.get(i), actual.get(i));
    }

    @Test
    public void maxsetAll() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{1,2,3});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{1,2,3});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetSingles() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{1,-1,3});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{3});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetAllNeg() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{-1,-1,-3});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetStartNeg() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{-1, 4, 45});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{4, 45});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetEndNeg() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{31,31,-3});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{31, 31});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetLong() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{1,1,3, -1, 4, 5, 3, 1, 2, -1});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{4, 5, 3, 1, 2});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetSinglePos() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{-1,-1,-3, -1, 4, -5, -3, -1, -2, -1});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{4});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetZigZag() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{1,-1,3, -1, 4, -5, 3, -1, 2, -1});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{4});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetCompareByLengthSecondOption() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{1, 3, -1, 1, 1, 1, 1});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{1, 1, 1, 1});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetCompareByLengthFirstOption() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{1, 1, 1, 1, -1, 2, 2});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{1, 1, 1, 1});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetCompareByEarliest() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{-1, -3, 4, 5, 1, -4, -3, -1, 3, 3, 1, -1});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{4, 5, 1});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetCompareByEarliestOfMany() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{
                10, -1,
                5, 5, -1,
                1, 1, 1, 6, 1, -1, // same length
                6, 1, 1, 1, 1, -1, // same length
                4, 3, 3, -1,
                1, 1, 1, 1, 5, -1,  //same length
                4, 3, 1, 1, 1, -1,  //same length
        });
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{1, 1, 1, 6, 1});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetRandom() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{3, 4, -3, 13, 5,4, -1, -5, 2 ,34, -3, 1,-3,2 });
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{2, 34});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetEmpty() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetLonePos() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{4});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{4});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetLoneNeg() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{-45});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetLargeNums() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{1967513926, 1540383426, -1303455736, -521595368});
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{1967513926, 1540383426,});
        assertListEquals(expected, actual);
    }

    @Test
    public void maxsetTrivial() {
        MaxNonNegativeSubarray a = new MaxNonNegativeSubarray();
        ArrayList<Integer> testCase = arrToList(new int[]{1, 2, 5, -7, 2, 5 });
        ArrayList<Integer> actual = a.maxset(testCase);
        ArrayList<Integer> expected = arrToList(new int[]{1, 2, 5});
        assertListEquals(expected, actual);
    }
}