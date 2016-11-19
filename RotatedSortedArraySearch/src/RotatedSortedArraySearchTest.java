import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by himanshu on 11/19/16.
 */
public class RotatedSortedArraySearchTest {

    @Test
    public void findMinIndex() throws Exception {
        class T{
            ArrayList<Integer> arr = new ArrayList<>();
            int expected;
            public T(int[] a, int e){
                for(Integer i: a) arr.add(i);
                this.expected =e;
            }
        }

        T[] tests = {
                new T(new int[]{}, -1),
                new T(new int[]{0}, 0),
                new T(new int[]{1}, 0),
                new T(new int[]{0,1}, 0),
                new T(new int[]{1,0}, 1),
                new T(new int[]{0,1,2}, 0),
                new T(new int[]{2,0,1}, 1),
                new T(new int[]{1,2,0}, 2),
        };
        for(T test: tests){
            int actual = (new RotatedSortedArraySearch()).findMinIndex(test.arr);
            String err = test.arr.toString();
            assertEquals(err, test.expected, actual);
        }
    }

    class T {
        ArrayList<Integer> arr;
        int target;
        int expected;
        public T(int[] inArray, int t, int e){
            arr = new ArrayList<Integer>();
            for(Integer i:inArray)arr.add(i);
            target = t;
            expected =e;
        }
    }

    @Test
    public void search() throws Exception {
        T[] tests = {
                new T(new int[]{0,1,2,3}, 0, 0),
                new T(new int[]{4,5,6,7,0,1,2}, 4, 0),
                new T(new int[]{0}, 0, 0),
                new T(new int[]{1}, 0, -1),
                new T(new int[]{0,2}, 2, 1),
                new T(new int[]{2,0,1}, 0, 1),
                new T(new int[]{2,0,1}, 1, 2),
                new T(new int[]{2,0,1}, 2, 0),
                new T(new int[]{2,0,1}, 3, -1),
                new T(new int[]{0,1,2}, 0, 0),
                new T(new int[]{0,1,2}, 1, 1),
                new T(new int[]{0,1,2}, 2, 2),
                new T(new int[]{0,1,2}, 3, -1),
                new T(new int[]{1,2,0}, 0, 2),
                new T(new int[]{1,2,0}, 1, 0),
                new T(new int[]{1,2,0}, 2, 1),
                new T(new int[]{1,2,0}, 3, -1),
        };

        for(T test: tests){
            int actual = (new RotatedSortedArraySearch()).search(test.arr, test.target);
            String err = test.arr.toString() + ":" + test.target;
            assertEquals(err, test.expected, actual);
        }
    }

}