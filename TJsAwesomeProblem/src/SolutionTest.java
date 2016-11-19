import com.sun.xml.internal.ws.developer.StreamingAttachment;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Created by himanshu on 9/14/16.
 */
public class SolutionTest {


    public class TestCase{

        ArrayList<Direction> in;
        ArrayList<Direction> expected;

        public TestCase(Direction [] i, Direction [] e ){
            this.in = new ArrayList<Direction>();
            this.expected = new ArrayList<Direction>();
            for(int x=0; x<i.length; x++)
                this.in.add(i[x]);

            for(int x=0; x<e.length; x++)
                this.expected.add(e[x]);
        }
    }


    @Test
    public void testAll(){
        TestCase [] testCases = {
            new TestCase(
                    new Direction[]{Direction.EAST, Direction.WEST, Direction.EAST},
                    new Direction[]{Direction.WEST}
            ),
            new TestCase(
                    new Direction[]{},
                    new Direction[]{}
            ),
            new TestCase(
                    new Direction[]{Direction.NORTH},
                    new Direction[]{Direction.SOUTH}
            ),
            new TestCase(
                    new Direction[]{Direction.EAST},
                    new Direction[]{Direction.WEST}
            ),
            new TestCase(
                    new Direction[]{Direction.SOUTH},
                    new Direction[]{Direction.NORTH}
            ),
            new TestCase(
                    new Direction[]{Direction.WEST},
                    new Direction[]{Direction.EAST}
            ),
            new TestCase(
                    new Direction[]{Direction.NORTH,Direction.NORTH, Direction.SOUTH, Direction.SOUTH},
                    new Direction[]{}
            ),
            new TestCase(
                    new Direction[]{Direction.NORTH,Direction.EAST, Direction.WEST, Direction.SOUTH},
                    new Direction[]{}
            ),
            new TestCase(
                    new Direction[]{Direction.NORTH,Direction.EAST, Direction.NORTH, Direction.SOUTH},
                    new Direction[]{Direction.WEST, Direction.SOUTH}
            ),
            new TestCase(
                    new Direction[]{Direction.NORTH,Direction.EAST, Direction.SOUTH, Direction.WEST},
                    new Direction[]{Direction.EAST, Direction.NORTH, Direction.WEST, Direction.SOUTH}
            ),
            new TestCase(
                    new Direction[]{
                        Direction.NORTH,
                        Direction.NORTH,
                        Direction.WEST,
                        Direction.SOUTH,
                        Direction.EAST,
                        Direction.EAST,
                        Direction.SOUTH,
                        Direction.WEST,
                    },
                    new Direction[]{
                            Direction.EAST,
                            Direction.NORTH,
                            Direction.WEST,
                            Direction.WEST,
                            Direction.NORTH,
                            Direction.EAST,
                            Direction.SOUTH,
                            Direction.SOUTH,
                    }
            ),
            new TestCase(
                    new Direction[]{
                            Direction.NORTH,
                            Direction.NORTH,
                            Direction.WEST,
                            Direction.SOUTH,
                            Direction.EAST,
                            Direction.EAST,
                            Direction.SOUTH,
                            Direction.WEST,
                    },
                    new Direction[]{
                            Direction.EAST,
                            Direction.NORTH,
                            Direction.WEST,
                            Direction.WEST,
                            Direction.NORTH,
                            Direction.EAST,
                            Direction.SOUTH,
                            Direction.SOUTH,
                    }
            ),
            new TestCase(
                    new Direction[]{
                            Direction.NORTH,
                            Direction.NORTH,
                            Direction.EAST,
                            Direction.EAST,
                            Direction.SOUTH,
                            Direction.SOUTH,
                            Direction.WEST,
                            Direction.WEST,
                    },
                    new Direction[]{
                            Direction.EAST,
                            Direction.EAST,
                            Direction.NORTH,
                            Direction.NORTH,
                            Direction.WEST,
                            Direction.WEST,
                            Direction.SOUTH,
                            Direction.SOUTH,
                    }
            ),
            new TestCase(
                    new Direction[]{Direction.NORTH,Direction.NORTH,Direction.NORTH, Direction.SOUTH,Direction.SOUTH, Direction.SOUTH},
                    new Direction[]{}
            ),
            new TestCase(
                    new Direction[]{Direction.NORTH,Direction.NORTH,Direction.NORTH, Direction.EAST, Direction.SOUTH,Direction.SOUTH, Direction.SOUTH},
                    new Direction[]{Direction.NORTH,Direction.NORTH,Direction.NORTH, Direction.WEST, Direction.SOUTH,Direction.SOUTH, Direction.SOUTH}
            ),
            new TestCase(
                    new Direction[]{Direction.EAST,Direction.WEST,Direction.WEST, Direction.EAST},
                    new Direction[]{}
            ),
            new TestCase(
                    new Direction[]{Direction.EAST,Direction.WEST,Direction.WEST, Direction.EAST},
                    new Direction[]{}
            ),
        };


        for(TestCase t: testCases){
            ArrayList<Direction> actual = (new Solution()).solve(t.in);
            assertEquals(t.expected, actual);
        }
    }

}