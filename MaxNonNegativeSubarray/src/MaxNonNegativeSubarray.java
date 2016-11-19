import java.util.ArrayList;

/**
 * Created by himanshu on 8/28/16.
 */
public class MaxNonNegativeSubarray {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        if(a.size() == 0) return a;
        ArrayList<ArrayList<Integer>> potentials = new ArrayList<ArrayList<Integer>>();
        potentials.add(new ArrayList<Integer>());
        for(int cur : a){
            if(cur < 0){
                potentials.add(new ArrayList<Integer>());
            } else {
                potentials.get(potentials.size()-1).add(cur);
            }
        }
//        System.out.println(potentials);

        ArrayList<Integer> out = potentials.get(0);
        for(ArrayList<Integer> cur : potentials){
            double sum = 0;
            for(Integer val:cur) sum+=val;
            if(sum > arrSum(out)) out = cur;
            if(sum == arrSum(out)){
                if(cur.size() > out.size()) out = cur;
                if(potentials.indexOf(cur) < potentials.indexOf(out)) out = cur;
            }
        }
        return out;
    }
    public double arrSum(ArrayList<Integer> arr){
        double sum = 0;
        for(Integer i:arr) sum+=i;
        return sum;
    }





}
