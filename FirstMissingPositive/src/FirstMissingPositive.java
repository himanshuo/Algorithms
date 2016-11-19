import java.util.ArrayList;

/**
 * Created by himanshu on 9/2/16.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(ArrayList<Integer> a) {
        for(int i=0;i<a.size();i++){
            // if useful value
            if(a.get(i) >= 1 && a.get(i) <= a.size()){
                itervelySet(a, a.get(i));
            }
        }


        for(int i=1;i<=a.size();i++){
            if(a.get(i-1) != i){
                return i;
            }
        }
        return a.size()+1;
    }

    public void recursivelySet(ArrayList<Integer> a, int val){
        assert val >= 1 && val <= a.size();
        int curValInSpot = a.get(val-1);
        a.set(val-1, val);

        if(curValInSpot >= 1 && curValInSpot <= a.size()){
            //if already set, then dont recurse
            if(a.get(curValInSpot-1) != curValInSpot)
                recursivelySet(a, curValInSpot);
        }
    }


    public void itervelySet(ArrayList<Integer> a, int val){
        assert val >= 1 && val <= a.size();
        int curValInSpot;
        while(val >= 1 && val <= a.size() && a.get(val-1) != val){
            curValInSpot = a.get(val-1);
            a.set(val-1, val);
            val = curValInSpot;
        }
    }
}

