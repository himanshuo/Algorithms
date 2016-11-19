import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by himanshu on 10/23/16.
 */
public class AllocateBooks {

    class Problem{
        int start, stop, b;

        public Problem(int start, int stop, int b){
            this.start = start;
            this.stop = stop;
            this.b = b;
        }
        public boolean equals(Object other){
            if (this == other) return true;
            if(other instanceof Problem &&
                    this.start == ((Problem)other).start &&
                    this.stop == ((Problem)other).stop &&
                    this.b == ((Problem)other).b)
                return true;

            return false;
        }
    }

    HashMap<Problem, Integer> cache;

    public AllocateBooks(){
        this.cache = new HashMap<Problem, Integer>();
    }


    public int books(ArrayList<Integer> a, int b) {

        return booksInternal(a, 0, a.size()-1, b);
    }

    public int booksInternal(ArrayList<Integer> a, int start, int stop, int b){
        if(b <=0) return -1;
        Problem cur = new Problem(start, stop, b);
        if(cache.containsKey(cur)){
            return cache.get(cur);
        }

        if(b == 1) {
            int out = 0;
            for(int i=start; i <= stop; i++) out+=a.get(i);
            return out;
        }
        int min = Integer.MAX_VALUE;
        for(int i =start; i <= stop; i++){
//            ArrayList<Integer> sublist = new ArrayList<Integer>(a.subList(i+1, stop)) ;
            int restMax = booksInternal(a, i+1, stop, b-1);
            if (restMax == -1) continue;
            int curMax = 0;
            for(int j = start; j<=i; j++){
                curMax += a.get(j);
            }
            int maxToUse = Math.max(restMax, curMax);
            min = min < maxToUse ? min : maxToUse;
        }
        cache.put(new Problem(start, stop, b), min);
        return min;
    }
}
