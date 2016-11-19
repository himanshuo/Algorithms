import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.lang.StringBuilder;
/**
 * Created by himanshu on 8/31/16.
 */
public class RearrangeToLargestNum {
        public String largestNumber(final List<Integer> a) {
            StringBuilder out = new StringBuilder("");
            Collections.sort(a, new NumComparator());

            for(Integer i: a){
                out.append(i);
            }
            return normalize(out.toString());
        }

        public String normalize(String res){

            while(res.length() > 1 && res.charAt(0) == '0'){
                res = res.substring(1);
            }
            return res;
        }

public class NumComparator implements Comparator<Integer>{
    public int compare(Integer a, Integer b){
        if(a==b) return 0;
        String aStr = Integer.toString(a);
        String bStr = Integer.toString(b);
        String combA = aStr + bStr;
        String combB = bStr + aStr;

        for(int i=0;i<combA.length();i++){
            if(combA.charAt(i) > combB.charAt(i)){
                return -1;
            } else if(combA.charAt(i) < combB.charAt(i)){
                return 1;
            }
        }
        return 0;


    }
}
}
