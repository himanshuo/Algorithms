import java.util.ArrayList;

/**
 * Created by himanshu on 11/5/16.
 */
public class ThreeSum {

    public int threeSumClosest(ArrayList<Integer> a, int b) {
        int l = 0, m = 1, r = 2;
        int closest = sum(a, l, m, r);
        //while (not past array & not overlapping)
        while(l<a.size() && m < a .size() && r < a.size() && l != m && m != r && l != r){
            int cur = sum(a, l, m, r);
            if(cur == b){
                return cur;
            } else if(closerToTarget(cur, closest, b)) {
                closest = cur;
            } else if(){

            }

        }
        return closest;

    }

    int sum(ArrayList<Integer> a , int l, int m, int r){
        return a.get(l) + a.get(m) + a.get(r);
    }

    boolean closerToTarget(int cur, int closest, int target){
        return Math.abs(cur - target) < Math.abs(closest - closest);
    }

}
