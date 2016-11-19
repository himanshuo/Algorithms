import java.util.ArrayList;

/**
 * Created by himanshu on 10/19/16.
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int x){
        int lo = 0, hi = arr.length-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] == x) return mid;
            else if(arr[mid]<x) lo = mid+1;
            else hi = mid-1;
        }

        return -1;
    }
}
