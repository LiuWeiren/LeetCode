package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution006Test {

    Solution006 solution = new Solution006();

    @Test
    void mySqrt() {
        // int[] numbers = {0, 1, 2, 3, 4, 8, 9, Integer.MAX_VALUE};
        int[] numbers = {9};

        for (int number : numbers) {
            System.out.println(solution.mySqrt(number));
        }
    }
}