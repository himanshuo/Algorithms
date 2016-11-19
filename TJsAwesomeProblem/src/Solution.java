import java.util.ArrayList;

/**
 * Created by himanshu on 9/14/16.
 */
public class Solution {

    public ArrayList<Direction> solve(ArrayList<Direction> in){
        if(in == null || in.size()==0) return new ArrayList<Direction>();
        ArrayList<Direction> out = new ArrayList<Direction>();
        out.add(opposite(in.get(in.size()-1)));
        for(int i=in.size()-2;i>=0;i--){
            Direction cur = in.get(i);
            if(out.size() == 0){
                out.add(opposite(cur));
            }else {
                Direction p = out.get(out.size()-1);
                if(cur == p){
                    out.remove(out.size()-1);
                } else {
                    out.add(opposite(cur));
                }
            }

        }
        return out;
    }


    public Direction opposite(Direction a){
        if(a == Direction.NORTH) return Direction.SOUTH;
        if(a == Direction.EAST) return Direction.WEST;
        if(a == Direction.SOUTH) return Direction.NORTH;
        return Direction.EAST;
    }
}
