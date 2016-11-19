import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by himanshu on 10/30/16.
 */
public class IntersectTest {

    class TestCase {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        public TestCase(int[] aArr, int[] bArr, int[] e){
            for(int i =0; i<aArr.length;i++) this.a.add(aArr[i]);
            for(int i =0; i<bArr.length;i++) this.b.add(bArr[i]);
            for(int i =0; i<e.length;i++) this.expected.add(e[i]);
        }
    }

    @Test
    public void testAll(){
        TestCase [] tests = {
                new TestCase(                           // BOTH EMPTY
                        new int[]{},
                        new int[]{},
                        new int[]{}
                ),
                new TestCase(                           //SINGLE EMPTY
                        new int[]{1},
                        new int[]{},
                        new int[]{}
                ),
                new TestCase(
                        new int[]{},
                        new int[]{4},
                        new int[]{}
                ),
                new TestCase(                           //BOTH FULL
                        new int[]{1},
                        new int[]{1},
                        new int[]{1}
                ),
                new TestCase(                           //ALL SAME
                        new int[]{1,2,3},
                        new int[]{1,2,3},
                        new int[]{1,2,3}
                ),
                new TestCase(                           //ALL DIFF
                        new int[]{1,2,3},
                        new int[]{5,6,7},
                        new int[]{}
                ),
                new TestCase(                           //ONE CONTAINED IN OTHER
                        new int[]{1,2,3},
                        new int[]{2},
                        new int[]{2}
                ),
                new TestCase(
                        new int[]{2},
                        new int[]{1,2,3},
                        new int[]{2}
                ),
                new TestCase(
                        new int[]{1,2,3},
                        new int[]{2, 3},
                        new int[]{2, 3}
                ),
                new TestCase(
                        new int[]{2, 3},
                        new int[]{1,2,3},
                        new int[]{2, 3}
                ),
                new TestCase(                           //REPEATED VALS
                        new int[]{1,1,2,3},
                        new int[]{1,2,3},
                        new int[]{1,2,3}
                ),
                new TestCase(
                        new int[]{1,2,2,3},
                        new int[]{1,2,3},
                        new int[]{1,2,3}
                ),
                new TestCase(                           //REPEATED VALS
                        new int[]{1,1,2,3},
                        new int[]{1,2,3},
                        new int[]{1,2,3}
                ),
                new TestCase(
                        new int[]{1,2,3},
                        new int[]{1,2,3,3},
                        new int[]{1,2,3}
                ),
                new TestCase(                           //ENDS ARE DIFF
                        new int[]{0,1,2,3,4,5},
                        new int[]{-1,1,2,3,4,6},
                        new int[]{1,2,3,4}
                ),
        };



        for(TestCase t:tests){
            ArrayList<Integer> actual = new Intersect().intersect(t.a, t.b);
            String err = t.a.toString() + " AND " + t.b.toString();
            assertEquals(err, t.expected, actual);
        }
    }

}