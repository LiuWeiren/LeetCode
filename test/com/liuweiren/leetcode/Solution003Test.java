package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Solution003Test {

    Solution003 solution = new Solution003();

    @Test
    void searchInsert() {
        List<KeyAndArray> keyAndArrays = new ArrayList<>();
        keyAndArrays.add(new KeyAndArray(5, new int[] { 1, 3, 5, 6 }));
        keyAndArrays.add(new KeyAndArray(2, new int[] { 1, 3, 5, 6 }));
        keyAndArrays.add(new KeyAndArray(7, new int[] { 1, 3, 5, 6 }));
        keyAndArrays.add(new KeyAndArray(0, new int[] { 1, 3, 5, 6 }));
        keyAndArrays.add(new KeyAndArray(5, new int[] { 1, 3, 5, 6, 7 }));

        for (KeyAndArray k : keyAndArrays) {
            System.out.println(solution.searchInsert(k.getArray(), k.getKey()));
        }

    }
    private static class KeyAndArray {
        private int key;
        private int[] array;

        public KeyAndArray(int key, int[] array) {
            this.key = key;
            this.array = array;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int[] getArray() {
            return array;
        }

        public void setArray(int[] array) {
            this.array = array;
        }
    }

    @Test
    void countAndSay() {
        for (int i = 1; i <= 30; i++) {
            System.out.println(solution.countAndSay(i));
        }
    }
}