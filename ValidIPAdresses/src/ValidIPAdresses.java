import java.util.ArrayList;

/**
 * Created by himanshu on 10/17/16.
 */
public class ValidIPAdresses {
    public static void main(String args[]){
        System.out.println(new ValidIPAdresses().restoreIpAddresses("0100100"));
    }


    public ArrayList<String> restoreIpAddresses(String a) {
        ArrayList<String> out = new ArrayList<String>();
        for(int i =1; i< a.length(); i++){
            for(int j = i+1; j<a.length(); j++){
                for(int k = j+1; k < a.length(); k++){
                    String A = a.substring(0, i);
                    String B = a.substring(i, j);
                    String C = a.substring(j, k);
                    String D = a.substring(k, a.length());

                    if(valid(A) && valid(B) && valid(C) && valid(D))
                        out.add(buildIp(A, B, C, D));

                }
            }
        }
        return out;
    }


    public boolean valid(String cur){
        try{
            int c = Integer.parseInt(cur);
            if(c != 0 && cur.charAt(0) == '0') return false;
            if(c == 0 && cur.length() != 1) return false;
            return c >= 0 && c <= 255;
        } catch (NumberFormatException e){
            return false;
        }

    }


    public String buildIp(String A, String B, String C, String D){
        return Integer.parseInt(A) + "." +
                Integer.parseInt(B) + "." +
                Integer.parseInt(C) + "." +
                Integer.parseInt(D);
    }
}
