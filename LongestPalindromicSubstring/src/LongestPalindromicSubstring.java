/**
 * Created by himanshu on 11/18/16.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String a) {
        if(a.length() == 0) return a;
        String longest = "";
        for(int i =0; i< a.length(); i++){
            if(i+1 < a.length()) {
                longest = updateLongest(a, longest, i, i + 1);
            }
            longest = updateLongest(a, longest, i, i);
        }
        return longest;
    }


    public String updateLongest(String a, String longest, int left, int right){
//        System.out.println(longest);
        assert left >= 0;
        assert right < a.length();

        if(a.charAt(left) != a.charAt(right)) return longest;
        assert a.charAt(left) == a.charAt(right);
        while(true){
            assert a.charAt(left) == a.charAt(right);
            if(left-1 >= 0 && right+1 < a.length() && a.charAt(left-1) == a.charAt(right+1)){
                left--;
                right++;
            } else {
                break;
            }
        }
        assert a.charAt(left) == a.charAt(right);

        if(longest.length() < right-left+1) {
            return a.substring(left, right+1);
        } else {
            return longest;
        }
    }
}
