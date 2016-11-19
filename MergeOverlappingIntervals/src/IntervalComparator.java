import java.util.Comparator;

/**
 * Created by himanshu on 8/29/16.
 */
public class IntervalComparator implements Comparator<Interval>{

    public int compare(Interval i, Interval j){
        return i.start - j.start;
    }
}
