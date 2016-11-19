import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by himanshu on 10/25/16.
 */
public class CountAndSayTest extends TestCase {

    @Test
    public void testAll(){
        String [] tests = {"1", "11", "21", "1211", "111221", "312211", "13112221"};
        for(int i = 0; i< tests.length; i++){
            CountAndSay cas = new CountAndSay();
            assertEquals(tests[i], tests[i], cas.countAndSay(i+1));
        }
    }

}