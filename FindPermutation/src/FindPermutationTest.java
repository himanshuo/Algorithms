import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by himanshu on 10/30/16.
 */
public class FindPermutationTest extends TestCase {
    class T{
        String A;
        ArrayList<Integer> expected;
        public T(String a, int[] e){
            this.A = a;

            this.expected = new ArrayList<Integer>();
            for(Integer i: e) this.expected.add(i);
        }
    }
    @Test
    public void testAll(){
        T[] tests = {
                new T("", new int[]{1}),                //EMPTY
                new T("I", new int[]{1,2}),             //SINGLE I
                new T("D", new int[]{2,1}),             //SINGLE D
                new T("II", new int[]{1,2,3}),          //PERMUTATIONS OF 2
                new T("ID", new int[]{2,3,1}),
                new T("DI", new int[]{2,1,3}),
                new T("DD", new int[]{3,2,1}),
                new T("IID", new int[]{2,3,4,1}),              //LARGER INPUT
                new T("IIIIII", new int[]{1,2,3,4,5,6,7}),
                new T("DDDDDD", new int[]{7,6,5,4,3,2,1}),
                new T("IDIDIDIDDDDIII", new int[]{8,9,7,10,6,11,5,12,4,3,2,1,13,14,15}),
        };

        for(T test:tests){
            ArrayList<Integer> actual = (new FindPermutation().findPerm(test.A, test.A.length()+1));
            assertEquals(test.A, test.expected, actual);
        }
    }
}