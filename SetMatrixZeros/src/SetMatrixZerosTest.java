import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by himanshu on 8/30/16.
 */
public class SetMatrixZerosTest {

    public void printInput(ArrayList<ArrayList<Integer>> in){
        for(ArrayList<Integer> arr: in){
            for(int i: arr){
                System.out.printf("%d ", i);
            }
            System.out.println("");
        }
    }

    public class TestCase{
        public ArrayList<ArrayList<Integer>> in;
        public ArrayList<ArrayList<Integer>> expected;

        public TestCase(ArrayList<ArrayList<Integer>> in, ArrayList<ArrayList<Integer>> expected){
            this.in = in;
            this.expected = expected;
        }



    }

    public TestCase getTestCase(String filename){
        String pathToFile = "/home/himanshu/Dropbox/java_practice/SetMatrixZeros/src/" + filename + ".test";
        ArrayList<ArrayList<Integer>> in = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathToFile), StandardCharsets.UTF_8);
            boolean solutionTime = false;
            for(String line:lines){
                if(line.contains("---")){
                    solutionTime = true;
                    continue;
                }
                if(solutionTime){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    for(String val:line.split(" ")){
                        temp.add(Integer.parseInt(val));
                    }
                    expected.add(temp);
                } else {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    for(String val:line.split(" ")){
                        temp.add(Integer.parseInt(val));
                    }
                    in.add(temp);
                }

            }

        } catch(Exception e){
            e.printStackTrace();
        }
        return new TestCase(in, expected);
    }


    public void assertMatrixEquals(String message, ArrayList<ArrayList<Integer>> expected, ArrayList<ArrayList<Integer>> actual){
        String msg = message +"\n";
        for(ArrayList<Integer> arr: expected){
            for(int i: arr){
                msg += i+",";
            }
            msg += "\n";
        }
        msg += "  !=\n";
        for(ArrayList<Integer> arr: actual){
            for(int i: arr){
                msg += i+",";
            }
            msg += "\n";
        }
        assertEquals(msg, expected.size(), actual.size());
        if(expected.size() > 0)
            assertEquals(msg, expected.get(0).size(), actual.get(0).size());
        for(int i=0;i<expected.size();i++){
            for(int j=0;j<expected.get(0).size();j++){
                assertEquals(msg, expected.get(i).get(j), actual.get(i).get(j));
            }
        }

    }



    @Test
    public void all() throws Exception {
        String [] testFiles = {
                "basic",
                "bottomIsZero",
                "center",
                "greaterHeight",
                "greaterWidth",
                "rightColumnIsZero",
                "rowIsZeroed",
                "single0",
                "single1",
                "singleCol",
                "singleRow",
                "topLeftZero",
                "twobytwo"
        };
        for(String testFile: testFiles){
            TestCase t = getTestCase(testFile);
            ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>(t.expected);
            (new SetMatrixZeros()).setZeroes(t.in);
            ArrayList<ArrayList<Integer>> actual = t.in;
            assertMatrixEquals(testFile, expected, actual);
        }

    }

}