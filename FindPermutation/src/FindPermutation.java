import java.util.ArrayList;

/**
 * Created by himanshu on 10/30/16.
 */
public class FindPermutation {


    final char DECREASE = 'D';
    final char INCREASE = 'I';

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    //O(n) space, O(n) speed
    public ArrayList<Integer> findPerm(final String A, int B) {

        ArrayList<Integer> out = new ArrayList<Integer>();
        int left=1, right=B;
        for(int i =0;i<A.length();i++){
            if(A.charAt(i) == DECREASE) left++;
            else right--;
        }
        //center
        out.add(left);
        left--;
        right++;
        for(int i =0;i<A.length();i++){
            if(A.charAt(i) == DECREASE) {
                out.add(left);
                left--;
            } else {
                out.add(right);
                right++;
            }
        }
        return out;
    }
}

