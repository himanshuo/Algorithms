import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by himanshu on 11/5/16.
 */
public class ThreeSumTest extends TestCase {


    public class T{
        ArrayList<Integer> a;
        int b;
        int expected;

        public T(int[] a, int b, int e){
            this.a = new ArrayList<Integer>();
            for(Integer i:a) this.a.add(i);
            this.b = b;
            this.expected = e;
        }
    }

    @Test
    public void testAll() throws Exception {
        T [] tests = {
                new T(new int[]{0,1,1}, 0, 2),
                new T(new int[]{0,1,1}, 1, 2),
                new T(new int[]{0,1,1}, 2, 2),
                new T(new int[]{0,1,1}, 3, 2),
                new T(new int[]{0,1,1,2}, 2, 2),
                new T(new int[]{0,1,1,2}, 3, 3),
                new T(new int[]{0,2,3,4}, 2, 5),
                new T(new int[]{-3, 4, 6}, 2, 7),
                new T(new int[]{-3, 4, 6}, 0, 7),
                new T(new int[]{1,2,2,3,5,6}, 0, 5),
                new T(new int[]{1,2,2,3,5,6}, 6, 6),
                new T(new int[]{1,2,3,4,5,6,6,8}, 0, 6),
                new T(new int[]{1,1,1,1,1,1,2}, 1, 3),
                new T(new int[]{1,1,1,1,1,1,2}, 0, 3),
                new T(new int[]{1,2,2,2,2,2}, 1, 5),
                new T(new int[]{1,2,2,2,2,2}, 0, 5),
                new T(new int[]{0,2,3,4,5,6,7}, 4, 5),
                new T(new int[]{-4, -1, 1, 2}, -4, -4),
                new T(new int[]{-4, -1, 1, 2}, -3, -3),
                new T(new int[]{-4, -1, 1, 2}, -2, -3),
                new T(new int[]{-4, -1, 1, 2}, -1, -1),
                new T(new int[]{-4, -1, 1, 2}, 0, -1),
                new T(new int[]{-4, -1, 1, 2}, 1, 2),
                new T(new int[]{-4, -1, 1, 2}, 2, 2),
                new T(new int[]{-4, -1, 1, 2}, 3, 2),
                new T(new int[]{-4, -1, 1, 2}, 4, 2),
        };

        for(T test: tests){
            ThreeSum d = new ThreeSum();
            int actual = d.threeSumClosest(test.a, test.b);
            String err = test.a.toString() + " -> " + test.b;
            assertEquals(err, test.expected, actual);
        }
    }


}

