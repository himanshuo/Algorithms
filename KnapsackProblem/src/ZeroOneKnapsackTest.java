import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by himanshu on 9/5/16.
 */
public class ZeroOneKnapsackTest {

    public class TestCase{
        ArrayList<Integer> vals;
        ArrayList<Integer> weights;
        int capacity;
        int expected;
        public TestCase(int[] v, int[] w, int c, int e){
            vals = new ArrayList<Integer>();
            weights = new ArrayList<Integer>();
            for(Integer i:v) vals.add(i);
            for(Integer x:w) weights.add(x);
            this.capacity = c;
            this.expected = e;

        }
    }

    @Test
    public void all() throws Exception {
        TestCase[] tests = {
            new TestCase(
                    new int[]{0},
                    new int[]{0},
                    0,
                    0
                    ),
            new TestCase(
                    new int[]{1},
                    new int[]{1},
                    1,
                    1
            ),
            new TestCase(
                    new int[]{1,5},
                    new int[]{0,1},
                    3,
                    6
            ),
            new TestCase(
                    new int[]{1,2},
                    new int[]{1,4},
                    3,
                    1
            ),
            new TestCase(
                    new int[]{1, 2, 3, 4},
                    new int[]{4, 3, 2, 1},
                    9,
                    6
            ),
            new TestCase(
                    new int[]{1, 1, 1, 99},
                    new int[]{1, 1, 1, 3},
                    3,
                    99
            )
        };


    }

}