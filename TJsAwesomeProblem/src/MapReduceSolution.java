import java.util.ArrayList;

/**
 * Created by himanshu on 9/15/16.
 */
public class MapReduceSolution {

    public class Tuple<X, Y> {
        public final X x;
        public final Y y;
        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }

    public ArrayList<Direction> solve(ArrayList<Direction> in){

        Tuple<> keyVals = map(in);
    }

    public Tuple<>



    public Direction opposite(Direction a){
        if(a == Direction.NORTH) return Direction.SOUTH;
        if(a == Direction.EAST) return Direction.WEST;
        if(a == Direction.SOUTH) return Direction.NORTH;
        return Direction.EAST;
    }
}
