import java.util.ArrayList;
import java.util.List;

/**
 * Created by himanshu on 10/30/16.
 */
public class Intersect {

    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        if(a.size() ==0 || b.size()==0)return new ArrayList<Integer>();
        int ai=0, bi=0;
        ArrayList<Integer> out = new ArrayList<Integer>();

        while(ai<a.size() && bi < b.size()){
            int aCur, bCur;
            aCur = a.get(ai);
            bCur = b.get(bi);

            if(aCur < bCur){
                ai++;
            } else if(bCur < aCur){
                bi++;
            } else {
                out.add(aCur);
                ai++;
                bi++;
                if(ai == a.size() || bi == b.size()) return out;
            }
        }

        if(ai <a.size()){
            while(ai < a.size()){
                if(a.get(ai) == b.get(bi-1)) {
                    out.add(a.get(ai));
                    return out;
                }
                ai++;
            }
        } else {
            while(bi < b.size()){
                if(b.get(bi) == a.get(ai-1)) {
                    out.add(b.get(bi));
                    return out;
                }
                bi++;
            }
        }
        return out;
    }
}
