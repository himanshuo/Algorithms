import java.util.ArrayList;

/**
 * Created by himanshu on 8/27/16.
 */
public class MergeIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> out = new ArrayList<Interval>(intervals);
        Interval in = normalize(newInterval);

        //empty case
        if(out.size() == 0) {
            out.add(in);
            return out;
        }

        //merge case
        for(int i = 0; i< out.size();i++){
            Interval cur = out.get(i);
            if(overlap(cur, in)){
                int start = getMin(in, cur);
                int end = getMax(in, out.get(i));
                while(i < out.size() && overlap(out.get(i), in)) {
                    end = getMax(in, out.get(i));
                    out.remove(out.get(i));
                }
                out.add(i, new Interval(start, end));

                return out;
            }

        }


        //no merge case
        for(int i = 0; i< out.size()-1;i++){
            Interval cur = out.get(i);

            if( cur.end < in.start &&
                    in.end < out.get(i+1).end ){
                out.add(i + 1, in);
                return out;
            }
        }

        //add to front
        if( in.end< out.get(0).start) {
            out.add(0,in);
            return out;
        }

        //add to end
        if(out.get(out.size()-1).end < in.start) {
            out.add(in);
            return out;
        }


        return out;
    }


    public boolean overlap(Interval i, Interval j){
       return (i.start < j.start && j.start < i.end) ||
               (i.start < j.end && j.end < i.end) ||
               (j.start <= i.start && i.end <= j.end) ||
               (i.start <= j.start && j.end <= i.end);
    }

    public int getMin(Interval i, Interval j){
        return i.start < j.start ? i.start : j.start;
    }

    public int getMax(Interval i, Interval j){
        return i.end > j.end ? i.end : j.end;
    }

    public Interval normalize(Interval i){
        if(i.start <= i.end) return i;
        return new Interval(i.end, i.start);
    }
}
