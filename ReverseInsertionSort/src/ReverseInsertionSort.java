import java.util.ArrayList;

/**
 * Created by himanshu on 10/7/16.
 */
public class ReverseInsertionSort {
    public void reverseSort(ArrayList<Integer> in){
        /*
        for i=1 -> in.length
            cur = in[i]
            while(j=i -> 1 && cur < in[j-1])
                in[j] = in[j-1]
                j--
            in[j]=cur
         */
        for(int i=1; i< in.size(); i++){
            int cur = in.get(i);
            int j = i;
            while(j > 0 && cur > in.get(j-1)){
                in.set(j, in.get(j-1));
                j--;
            }
            in.set(j, cur);
        }
    }
}
