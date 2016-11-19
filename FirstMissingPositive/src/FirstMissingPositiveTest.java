import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Created by himanshu on 9/2/16.
 */
public class FirstMissingPositiveTest {

    public class TestCase{
        ArrayList<Integer> input;
        int expected;
        public TestCase(int [] in, int expected){
            this.input = new ArrayList<Integer>();
            for(int i=0;i<in.length; i++)
                this.input.add(new Integer(in[i]));
            this.expected = expected;
        }
    }

    @Test
    public void all() throws Exception {
        TestCase[] tests = {
            new TestCase(new int[]{0, 2, 3, 4}, 1),
            new TestCase(new int[]{-1, 0, 2}, 1),
            new TestCase(new int[]{-1,-2,-3}, 1),
            new TestCase(new int[]{0,0, 0, 0}, 1),
            new TestCase(new int[]{2, 2}, 1),
            new TestCase(new int[]{1, 1}, 2),
            new TestCase(new int[]{-1,-3,-4, 8}, 1),
            new TestCase(new int[]{0}, 1),
            new TestCase(new int[]{}, 1),
            new TestCase(new int[]{0,2}, 1),
            new TestCase(new int[]{1, 2, 3}, 4),
            new TestCase(new int[]{1,2, 0}, 3),
            new TestCase(new int[]{1,2,3,4}, 5),
            new TestCase(new int[]{3, 4, -1, 1}, 2),
            new TestCase(new int[]{-8,-7,-6}, 1),
            new TestCase(new int[]{9,10,11}, 1),
            new TestCase(new int[]{1, 3, 5}, 2),
            new TestCase(new int[]{1, 1, 3}, 2),
            new TestCase(new int[]{1, 1, 3, 3, 5, 5}, 2),
            new TestCase(new int[]{1, 1, 1, 1, 1, 2, 3, 4, 5, 6}, 7),


            new TestCase(new int[]{1,2,3}, 4),
            new TestCase(new int[]{2,1}, 3),
            new TestCase(new int[]{3, 2, 1}, 4),


            new TestCase(new int[]{4, 1, 1, 1}, 2),
            new TestCase(new int[]{4, 3, 2, 1}, 5),
            new TestCase(new int[]{3, 2, 1}, 4),



            new TestCase(new int[]{0,1,2,3}, 4),
            new TestCase(new int[]{3, 2, 1, 0}, 4),
            new TestCase(new int[]{0,0,1,2,3}, 4),


            new TestCase(new int[]{2, 3, 1}, 4),


            new TestCase(new int[]{4, 2,1, 3}, 5),
                new TestCase(new int[]{1}, 2),

        };

        for(TestCase t: tests){
            try{
                String msg = t.input.toString();
                int actual = (new FirstMissingPositive()).firstMissingPositive(t.input);
                assertEquals(msg, t.expected, actual);
            } catch (Exception e){
                System.out.println("Exception! for:" + t.input.toString());
                e.printStackTrace();
                throw e;
            }
        }
    }

}