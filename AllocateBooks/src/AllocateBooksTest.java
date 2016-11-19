import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by himanshu on 10/23/16.
 */
public class AllocateBooksTest extends TestCase {

    class TestStruct {
        ArrayList<Integer> inList;
        int b;
        int expected;
        public TestStruct(int[] i, int b, int e){
            inList = new ArrayList<Integer>();
            for(Integer x : i) inList.add(x);
            this.b = b;
            this.expected = e;
        }
    }

    public void testAll(){
        TestStruct [] tests = {
                new TestStruct(new int[]{1},1,1),
                new TestStruct(new int[]{1,2},1,3),
                new TestStruct(new int[]{1,2,3},1,6),
                new TestStruct(new int[]{1,2,3},2,3),
                new TestStruct(new int[]{2,2,3},2,4),
                new TestStruct(new int[]{5,2,3},2,5),
                new TestStruct(new int[]{1,1,1,1,9},2,9),
                new TestStruct(new int[]{12,34,67,90},2,113),
                new TestStruct(new int[]{9,1,2},2,9),
                new TestStruct(new int[]{1,1,1},3,1),
                new TestStruct(new int[]{2,1,3},3,3),
                new TestStruct(new int[]{1,1,9},3,9),
                new TestStruct(new int[]{1,1,1,1},3,2),
                new TestStruct(new int[]{1,2,3,1},3,3),
                new TestStruct(new int[]{1,2,3,1},3,3),
                new TestStruct(new int[]{91, 20, 62, 33, 97, 31, 88, 89, 73, 77, 4, 58, 0, 54, 60, 15, 47, 80, 30, 55, 46, 7, 38, 0, 26, 35, 57, 13}, 24, 97),
                new TestStruct(new int[]{34, 11, 4, 26, 91, 90, 22, 64, 90, 84, 13, 41, 27, 79, 84, 37, 70, 61, 81, 65, 2, 32, 32, 54, 59, 47, 77, 62, 10, 19}, 22, 91)
        };


        for(TestStruct t: tests){
            AllocateBooks ab = new AllocateBooks();
            int actual = ab.books(t.inList, t.b);
            String err = t.inList.toString() + " with " + t.b + " students";
            assertEquals(err,  t.expected, actual);
        }

    }
}