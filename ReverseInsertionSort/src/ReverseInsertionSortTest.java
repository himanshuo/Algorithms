import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by himanshu on 10/7/16.
 */
public class ReverseInsertionSortTest {

    public void assertReverseSorted(ArrayList<Integer> a){
        for(int i=0;i<a.size()-1;i++){
            assertTrue(a.toString(), a.get(i) >= a.get(i+1));
        }

    }

    public ArrayList<Integer> toArrayList(int [] in){
        ArrayList<Integer> out = new ArrayList<Integer>();
        for(Integer i: in){
            out.add(i);
        }
        return out;
    }

    @Test
    public void reverseSort() throws Exception {
        int[][] tests = {
                new int[]{1,2,3,4},
                new int[]{},
                new int[]{0},
                new int[]{1},
                new int[]{-1,0,1},
                new int[]{1,0,-1},
                new int[]{123,34,54,23},
                new int[]{4,3,2,1},
                new int[]{}
        };

        for(int[] test: tests){
            ArrayList<Integer> t = toArrayList(test);
            ReverseInsertionSort r = new ReverseInsertionSort();
            r.reverseSort(t);
            assertReverseSorted(t);
        }

    }

}