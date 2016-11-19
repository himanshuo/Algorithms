import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by himanshu on 11/18/16.
 */
public class LongestPalindromicSubstringTest {

    class T {
        String in;
        String expected;
        public T(String i, String e){
            this.in = i;
            this.expected = e;
        }
    }

    @Test
    public void longestPalindrome() throws Exception {
        T [] tests = {
                new T("aaaabaaa", "aaabaaa"),
                new T("abbac", "abba"),
                new T("aaaa", "aaaa"),
                new T("aabcc", "aa"),
                new T("abab", "aba"),
                new T("abbc", "bb"),
                new T("aabb", "aa"),
                new T("abba", "abba"),
                new T("", ""),
                new T("a", "a"),
                new T("aa", "aa"),
                new T("ab", "a"),
                new T("abc", "a"),
                new T("abb", "bb")
        };

        for(T t: tests){
            String actual = (new LongestPalindromicSubstring()).longestPalindrome(t.in);
            assertEquals(t.in, t.expected, actual);
        }
    }

}