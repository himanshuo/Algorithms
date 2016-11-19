import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import java.util.ArrayList;

/**
 * Created by himanshu on 8/27/16.
 */
public class MergeOverlappingIntervalsTest extends TestCase {

    public void assertEqualIntervals(ArrayList<Interval> expected,ArrayList<Interval> actual){
        String msg = "";
        for(int i = 0; i < expected.size();i++){
            msg += "["+expected.get(i).start+","+expected.get(i).end+"]";
        }
        msg += "  !=  ";
        for(int i = 0; i < actual.size();i++){
            msg += "["+actual.get(i).start+","+actual.get(i).end+"]";
        }
        assertEquals(msg, expected.size(), actual.size());
        for(int i = 0; i< actual.size();i++){
            assertEquals(msg, expected.get(i).start, actual.get(i).start);
            assertEquals(msg, expected.get(i).end, actual.get(i).end);
        }
    }

    @Test
    public void testBasic(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,3));
        input.add(new Interval(6,9));
        input.add(new Interval(2,5));
        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,5));
        expected.add(new Interval(6,9));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);

        assertEqualIntervals(expected, actual);
    }

    @Test
    public void testMultiOverlap(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,2));
        input.add(new Interval(3,5));
        input.add(new Interval(6,7));
        input.add(new Interval(8,10));
        input.add(new Interval(12,16));
        input.add(new Interval(4,9));


        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,2));
        expected.add(new Interval(3,10));
        expected.add(new Interval(12,16));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);

        assertEqualIntervals(expected, actual);
    }

    @Test
    public void testMultiDifferentOverlaps(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,2));
        input.add(new Interval(1,5));
        input.add(new Interval(6,10));
        input.add(new Interval(9,11));
        input.add(new Interval(12,16));
        input.add(new Interval(15,16));


        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,5));
        expected.add(new Interval(6,11));
        expected.add(new Interval(12,16));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);

        assertEqualIntervals(expected, actual);
    }

    @Test
    public void testIntervalsStartingAtSameSpot(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,2));
        input.add(new Interval(2,5));
        input.add(new Interval(5,10));


        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,2));
        expected.add(new Interval(2,5));
        expected.add(new Interval(5,10));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);

        assertEqualIntervals(expected, actual);
    }

    @Test
    public void testOverlappingIntervalsStartingAtSameSpot(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,2));
        input.add(new Interval(2,5));
        input.add(new Interval(1,5));


        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,5));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);

        assertEqualIntervals(expected, actual);
    }

    @Test
    public void testNoOverlap(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,2));
        input.add(new Interval(6,7));
        input.add(new Interval(3,5));
        input.add(new Interval(8,10));

        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,2));
        expected.add(new Interval(3,5));
        expected.add(new Interval(6,7));
        expected.add(new Interval(8,10));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);
        assertEqualIntervals(expected, actual);
    }


    @Test
    public void testSurroundingInput(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(3,9));
        input.add(new Interval(1,2));
        input.add(new Interval(4,8));
        input.add(new Interval(10,12));

        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,2));
        expected.add(new Interval(3,9));
        expected.add(new Interval(10,12));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);
        assertEqualIntervals(expected, actual);
    }


    @Test
    public void testSurroundedInputCenter(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,3));
        input.add(new Interval(4,8));
        input.add(new Interval(10,12));
        input.add(new Interval(6,7));

        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,3));
        expected.add(new Interval(4,8));
        expected.add(new Interval(10,12));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);
        assertEqualIntervals(expected, actual);


    }

    @Test
    public void testSurroundedInputFront(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,3));
        input.add(new Interval(4,8));
        input.add(new Interval(10,12));
        input.add(new Interval(1,2));

        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,3));
        expected.add(new Interval(4,8));
        expected.add(new Interval(10,12));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);
        assertEqualIntervals(expected, actual);

    }

    @Test
    public void testSurroundedInputEnd(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,3));
        input.add(new Interval(4,8));
        input.add(new Interval(10,12));
        input.add(new Interval(11,12));

        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,3));
        expected.add(new Interval(4,8));
        expected.add(new Interval(10,12));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);
        assertEqualIntervals(expected, actual);

    }

    @Test
    public void testInputAlreadyIntervalFront(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,2));
        input.add(new Interval(1,2));
        input.add(new Interval(4,8));
        input.add(new Interval(10,12));

        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,2));
        expected.add(new Interval(4,8));
        expected.add(new Interval(10,12));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);
        assertEqualIntervals(expected, actual);

    }

    @Test
    public void testInputAlreadyIntervalCenter(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,2));
        input.add(new Interval(4,8));
        input.add(new Interval(4,8));
        input.add(new Interval(10,12));

        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,2));
        expected.add(new Interval(4,8));
        expected.add(new Interval(10,12));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);
        assertEqualIntervals(expected, actual);


    }
    @Test
    public void testInputAlreadyIntervalEnd(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,2));
        input.add(new Interval(4,8));
        input.add(new Interval(10,12));
        input.add(new Interval(10,12));

        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,2));
        expected.add(new Interval(4,8));
        expected.add(new Interval(10,12));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);
        assertEqualIntervals(expected, actual);


    }
    @Test
    public void testReverseInputInterval(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,2));
        input.add(new Interval(3,6));
        input.add(new Interval(10,8));

        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,2));
        expected.add(new Interval(3,6));
        expected.add(new Interval(8,10));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);
        assertEqualIntervals(expected, actual);
    }

    @Test
    public void testAddToEnd(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,2));
        input.add(new Interval(3,9));
        input.add(new Interval(8,10));

        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,2));
        expected.add(new Interval(3,10));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);
        assertEqualIntervals(expected, actual);
    }

    @Test
    public void testAddToFront(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,2));
        input.add(new Interval(1,6));
        input.add(new Interval(8,10));


        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,6));
        expected.add(new Interval(8,10));

        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);
        assertEqualIntervals(expected, actual);
    }

    @Test
    public void testAddToEmpty(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        ArrayList<Interval> expected = new ArrayList<Interval>();
        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);
        assertEqualIntervals(expected, actual);
    }

    @Test
    public void testSingleMerge(){
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,9));
        input.add(new Interval(8,10));
        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(1,10));
        ArrayList<Interval> actual = (new MergeOverlappingIntervals()).merge(input);
        assertEqualIntervals(expected, actual);
    }




}