package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (a.size() == 0 || a.get(0).size() == 0) return result;
        int left = 0, right = a.get(0).size(), up = 1, down = a.size(), dir = 0;
        // 0: right
        // 1: down
        // 2: left
        // 3: up
        int r = 0, c = 0;
        int count = a.get(0).size() * a.size();
        result.add(a.get(0).get(0));
        while (result.size() < count) {
            if (dir == 0) {  // going right
                if (c + 1 != a.get(0).size()) {
                    c++;
                    for (int i = c; i < right; i++) {
                        result.add(a.get(r).get(c));
                        if (c != right - 1) c++;
                    }
                    right--;
                }
                dir = 1;
            } else if (dir == 1) { // going down
                if (r + 1 != a.size()) {
                    r++;
                    for (int i = r; i < down; i++) {
                        result.add(a.get(r).get(c));
                        if (r != down - 1) r++;
                    }
                    down--;
                }
                dir = 2;
            } else if (dir == 2) { // going left
                if (c - 1 != -1) {
                    c--;
                    for (int i = c; i >= left; i--) {
                        result.add(a.get(r).get(c));
                        if (c != left) c--;
                    }
                    left++;
                }
                dir = 3;
            } else {    // going up
                if (r - 1 != -1) {
                    r--;
                    for (int i = r; i >= up; i--) {
                        result.add(a.get(r).get(c));
                        if (r != up) r--;
                    }
                    up++;
                }
                dir = 0;
            }
        }
        return result;
    }
}
