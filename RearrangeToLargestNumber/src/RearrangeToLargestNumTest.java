import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by himanshu on 8/31/16.
 */
public class RearrangeToLargestNumTest {

    @Test
    public void basic() throws Exception {
        ArrayList<Integer> in = new ArrayList<Integer>();
        in.add(1);
        in.add(0);
        assertEquals("10", (new RearrangeToLargestNum()).largestNumber(in));
    }
    @Test
    public void tieNonZero() throws Exception {
        ArrayList<Integer> in = new ArrayList<Integer>();
        in.add(10);
        in.add(1);
        assertEquals("110", (new RearrangeToLargestNum()).largestNumber(in));
    }

    @Test
    public void tieZero() throws Exception {
        ArrayList<Integer> in = new ArrayList<Integer>();
        in.add(1230);
        in.add(12300);
        assertEquals("123012300", (new RearrangeToLargestNum()).largestNumber(in));
    }
    @Test
    public void leadingZeros() throws Exception {
        ArrayList<Integer> in = new ArrayList<Integer>();
        in.add(100);
        in.add(20);
        assertEquals("20100", (new RearrangeToLargestNum()).largestNumber(in));
    }
    @Test
    public void same() throws Exception {
        ArrayList<Integer> in = new ArrayList<Integer>();
        in.add(33);
        in.add(33);
        in.add(4);
        assertEquals("43333", (new RearrangeToLargestNum()).largestNumber(in));
    }

    @Test
    public void extraNumIsGood() throws Exception {
        ArrayList<Integer> in = new ArrayList<Integer>();
        in.add(121);
        in.add(12);
        assertEquals("12121", (new RearrangeToLargestNum()).largestNumber(in));
    }

    @Test
    public void extraNumIsBad() throws Exception {
        ArrayList<Integer> in = new ArrayList<Integer>();
        in.add(120);
        in.add(12);
        in.add(121);

        assertEquals("12121120", (new RearrangeToLargestNum()).largestNumber(in));
    }

    @Test
    public void onlyZero() throws Exception {
        ArrayList<Integer> in = new ArrayList<Integer>();
        in.add(0);
        in.add(0);

        assertEquals("0", (new RearrangeToLargestNum()).largestNumber(in));
    }


}