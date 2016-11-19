import java.util.ArrayList;

/**
 * Created by himanshu on 9/4/16.
 */
public class ZeroOneKnapsack {
    /*
    * The knapsack problem is:
    * Given a set of items, each with a weight and a value,
    * determine the number of each item
    * so that the total weight is less than or equal to a given limit
    * and the total value is as large as possible.
    *
    * */

    /**
     * SUDO CODE
     *
         Input:
         Values (stored in array v)
         Weights (stored in array w)
         Number of distinct items (n)
         Knapsack capacity (W)
         m[item_num, weight]

         for j from 0 to W do:
             m[0, j] := 0

         for i from 1 to n do:  // for each item
            for j from 0 to W do:   //for each weight,
              if w[i] > j then:         //  if cur > cur_max
                 m[i, j] := m[i-1, j]       // take previous_obj_value
              else:                     //else
                 m[i, j] := max(m[i-1, j], m[i-1, j-w[i]] + v[i])   // use max_value(previous_obj_value, before_previous_value + cur_obj_value)
     *
     */
    public int solve(ArrayList<Integer> vals, ArrayList<Integer> weights, int capacity){
        assert vals.size() == weights.size();
        ArrayList<ArrayList<Integer>> m = new ArrayList<ArrayList<Integer>>();
        int n = vals.size();
        for(int i=0;i<n;i++){
            m.add(new ArrayList<Integer>());
        }
        for(int i =0;i<n;i++){
            for(int w=0;w<capacity;w++){
                if(weights.get(i) > w){
                    m.get(i).set(w, m.get(i-1).get(w));
                }else{
                    int a = m.get(i-1).get(w);
                    int b = m.get(i-1).get(w-weights.get(i)) + vals.get(i);
                    int val = Math.max(a,b);
                    m.get(i).set(w,val);
                }
            }
        }
        ArrayList<Integer> last = m.get(m.size()-1);
        return last.get(last.size()-1);
    }
}
