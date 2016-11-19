import java.util.ArrayList;
import java.util.List;

/**
 * Created by himanshu on 11/19/16.
 */
public class RotatedSortedArraySearch {
    public int search(final List<Integer> a, int b) {
        int minIndex = findMinIndex(a);
        if(minIndex == -1) return -1;
        if(a.get(minIndex) == b) return minIndex;

        int lo, hi;
        int oneLessThanMinIndex = minIndex -1;
        if(oneLessThanMinIndex < 0) oneLessThanMinIndex = a.size()-1;

        if(b >= a.get(0) && b <= a.get(oneLessThanMinIndex)) {
            lo =0;
            hi = oneLessThanMinIndex;
        } else {
            lo = minIndex;
            hi = a.size()-1;
        }

//        System.out.println(lo);
//        System.out.print(hi);
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(b == a.get(mid)) return mid;
            else if (a.get(mid) < b) lo = mid+1;
            else hi = mid-1;
        }
        return a.get(lo) == b ? lo: -1;
    }


    public boolean isMin(final List<Integer> a, int index){
        int cur = a.get(index);
        int previous, next;
        if(index == 0){
            previous = a.get(a.size()-1);
            next = a.get(index+1);
        } else if (index == a.size()-1){
            previous = a.get(index-1);
            next = a.get(0);
        } else {
            previous = a.get(index-1);
            next = a.get(index+1);
        }
        return previous > cur && next > cur;
    }

    public int findMinIndex(List<Integer> a){
        if(a.size() == 0) return -1;
        int lo = 0, hi = a.size()-1;
        int min = -1;
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            if(isMin(a, mid)) {
                min = mid;
                break;
            }
            else if(a.get(mid) > a.get(hi)) lo = mid + 1;
            else hi = mid - 1;
        }
        min = min == -1 ? lo:min;
        return min;
    }


}
