import java.util.ArrayList;
import junit.framework.TestCase;


/**
 * Created by himanshu on 11/3/16.
 */
public class DiffK extends TestCase{


    public int diffPossible(ArrayList<Integer> a, int b) {

        int l = 0;
        int r = 1;
        while(r < a.size() && l < a.size() && l!=r){

            if(a.get(r) - a.get(l) == b){
                return 1;
            } else if (a.get(r) - a.get(l) < b){
                r++;
            } else {
                if(l + 1 == r){
                    r++;
                } else {
                    l++;
                }

            }
        }
        return 0;
    }


}
