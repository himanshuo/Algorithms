package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by himanshu on 8/23/16.
 */
public class MainTest {

    public void printInput(ArrayList<ArrayList<Integer>> in){
            for(ArrayList<Integer> arr: in){
                for(int i: arr){
                    System.out.printf("%d ", i);
                }
                System.out.println("");
            }
    }

    public ArrayList<ArrayList<Integer>> getInput(String filename){
        String pathToFile = "/home/himanshu/Dropbox/java_practice/SpiralOrderMatrix/src/com/company/" + filename + ".test";
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathToFile), StandardCharsets.UTF_8);
            for(String line:lines){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for(String val:line.split(" ")){
                    temp.add(Integer.parseInt(val));
                }
                out.add(temp);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return out;
    }

    @Test
    public void testBasic() {
        ArrayList<ArrayList<Integer>> in = getInput("basic");
        List<Integer> expected = Arrays.asList(new Integer[]{1, 2, 3, 6, 9, 8, 7, 4, 5});
        List<Integer> actual = (new Main()).spiralOrder(in);
        assertEquals(expected,actual);
    }

    @Test
    public void testSingle() {
        ArrayList<ArrayList<Integer>> in = getInput("single");
        List<Integer> expected = Arrays.asList(new Integer[]{1});
        List<Integer> actual = (new Main()).spiralOrder(in);
        assertEquals(expected,actual);
    }

    @Test
    public void testEmpty() {
        ArrayList<ArrayList<Integer>> in = new ArrayList<ArrayList<Integer>>();
        List<Integer> expected = Arrays.asList(new Integer[]{});
        List<Integer> actual = (new Main()).spiralOrder(in);
        assertEquals(expected,actual);
    }

    @Test
    public void testEvenLengthBox() {
        ArrayList<ArrayList<Integer>> in = getInput("evenLengthBox");
        List<Integer> expected = Arrays.asList(new Integer[]{1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10});
        List<Integer> actual = (new Main()).spiralOrder(in);
        assertEquals(expected,actual);
    }

    @Test
    public void testEvenLengthLargeBox() {
        ArrayList<ArrayList<Integer>> in = getInput("evenLengthLargeBox");
        List<Integer> expected = Arrays.asList(new Integer[]{
            1, 2, 3, 4, 5, 6,
                12, 18, 24, 30, 36,
                35, 34, 33, 32, 31,
                25, 19, 13, 7,
                8, 9, 10, 11,
                17, 23, 29,
                28, 27, 26,
                20, 14,
                15, 16,
                22, 21});
        List<Integer> actual = (new Main()).spiralOrder(in);
        assertEquals(expected,actual);
    }

    @Test
    public void testOddLengthLargeBox() {
        ArrayList<ArrayList<Integer>> in = getInput("oddLengthLargeBox");
        List<Integer> expected = Arrays.asList(new Integer[]{
            1, 2, 3, 4, 5,
                10, 15, 20, 25,
                24, 23, 22, 21,
                16, 11, 6,
                7, 8, 9,
                14, 19,
                18, 17,
                12,
                13
        });
        List<Integer> actual = (new Main()).spiralOrder(in);
        assertEquals(expected,actual);
    }

    @Test
    public void testLongerLength() {
        ArrayList<ArrayList<Integer>> in = getInput("longerLength");
        List<Integer> expected = Arrays.asList(new Integer[]{1, 2, 3, 4, 8, 7, 6, 5});
        List<Integer> actual = (new Main()).spiralOrder(in);
        assertEquals(expected,actual);
    }

    @Test
    public void testLongerWidth() {
        ArrayList<ArrayList<Integer>> in = getInput("longerWidth");
        List<Integer> expected = Arrays.asList(new Integer[]{
            1, 2, 3,
                6, 9, 12, 15, 18, 21,
                20, 19,
                16, 13, 10, 7, 4,
                5,
                8, 11, 14, 17
        });
        List<Integer> actual = (new Main()).spiralOrder(in);
        assertEquals(expected,actual);
    }

    @Test
    public void testHorizontalLine() {
        ArrayList<ArrayList<Integer>> in = getInput("horizontalLine");
        List<Integer> expected = Arrays.asList(new Integer[]{
                1, 2, 3, 4, 5
        });
        List<Integer> actual = (new Main()).spiralOrder(in);
        assertEquals(expected,actual);
    }

    @Test
    public void testVerticalLine() {
        ArrayList<ArrayList<Integer>> in = getInput("verticalLine");
        List<Integer> expected = Arrays.asList(new Integer[]{
                1, 2, 3, 4, 5
        });
        List<Integer> actual = (new Main()).spiralOrder(in);
        assertEquals(expected,actual);
    }

}