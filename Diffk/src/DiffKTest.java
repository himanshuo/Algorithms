import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by himanshu on 11/3/16.
 */
public class DiffKTest extends TestCase {


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
                new T(new int[]{0,1}, 1, 1),                    //BASIC TRUE
                new T(new int[]{0,1}, 0, 0),                    //BASIC FALSE
                new T(new int[]{0,1,1}, 0, 1),                  //LONGER
                new T(new int[]{0,1,1}, 1, 1),
                new T(new int[]{0,1,1,2}, 2, 1),
                new T(new int[]{0,1,1,2}, 3, 0),
                new T(new int[]{0,2,3,4}, 2, 1),
                new T(new int[]{-3, 4, 6}, 2, 1),               //NEG NUMBERS
                new T(new int[]{-3, 4, 6}, 0, 0),
                new T(new int[]{1,2,2,3,5,6}, 0, 1),            //REPEAT AT START
                new T(new int[]{1,2,2,3,5,6}, 6, 0),
                new T(new int[]{1,2,3,4,5,6,6,8}, 0, 1),            //REPEAT AT END
                new T(new int[]{1,1,1,1,1,1,2}, 1, 1),
                new T(new int[]{1,1,1,1,1,1,2}, 0, 1),
                new T(new int[]{1,2,2,2,2,2}, 1, 1),
                new T(new int[]{1,2,2,2,2,2}, 0, 1),
                new T(new int[]{0,2,3,4,5,6,7}, 4, 1),                //Result is on outside

        };

        for(T test: tests){
            DiffK d = new DiffK();
            int actual = d.diffPossible(test.a, test.b);
            String err = test.a.toString() + " -> " + test.b;
            assertEquals(err, test.expected, actual);
        }
    }

}