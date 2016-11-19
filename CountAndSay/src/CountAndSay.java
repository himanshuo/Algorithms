/**
 * Created by himanshu on 10/25/16.
 */
public class CountAndSay {

    public String countAndSay(int a) {
        if(a <= 1) return "1";
        String cur = "1";
        for(int i = 1; i<a;i++){
            cur = getNext(cur);
        }
        return cur;
    }


    public String getNext(String cur){
        StringBuilder out = new StringBuilder();
        int curCount = 0;
        String curStr = ""+cur;
        char curVal = 'X';
        for(int i = 0; i < curStr.length(); i++){
            if(curVal == curStr.charAt(i)){
                curCount++;
            } else {
                if(curVal != 'X'){
                    out.append(curCount);
                    out.append(curVal);
                }

                curVal = curStr.charAt(i);
                curCount = 1;

            }
        }
        if(curVal != 'X'){
            out.append(curCount);
            out.append(curVal);
        }

        return out.toString();

    }
}
