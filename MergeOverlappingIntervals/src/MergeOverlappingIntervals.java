import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by himanshu on 8/29/16.
 */
public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> out = new ArrayList<Interval>();
        // normalize
        for(int i=0;i<intervals.size();i++){
            out.add(normalize(intervals.get(i)));
        }
        //sort by starting point
        Collections.sort(out, new IntervalComparator() );
        //merge
        for(int i=0;i<out.size()-1;i++){
            Interval cur = out.get(i);
            Interval next = out.get(i+1);
            if(overlap(cur, next)){
                int start = cur.start < next.start ? cur.start:next.start;
                int end = cur.end > next.end ? cur.end:next.end;
                out.remove(i);
                out.remove(i);
                out.add(i, new Interval(start, end));
                i--;
            }
        }

        return out;
    }

    public boolean overlap(Interval i, Interval j){
        return (i.start < j.start && j.start < i.end) ||
                (i.start < j.end && j.end < i.end) ||
                (i.start <= j.start && j.end <= i.end) ||
                (j.start <= i.start && i.end <= j.end);
    }

    public Interval normalize(Interval i){
        return i.start <= i.end ? i: new Interval(i.end, i.start);
    }


    public String normalize(String res){
        String out = new String(res);
        while(out.length() > 0 && out.charAt(0) == '0'){
            out = out.substring(1);
        }
        return res;
    }

}
