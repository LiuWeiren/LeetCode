package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution083Test {

    Solution083 solution = new Solution083();

    @Test
    void isRectangleOverlap() {
        // int[] rec2 = {0, 0, 2, 2};
        // int[] rec1 = {1, 1, 3, 3};

        // int[] rec2 = {0, 0, 1, 1};
        // int[] rec1 = {1, 0, 2, 1};

        // int[] rec1 = {11, 12, 13, 13};
        // int[] rec2 = {17, 1, 17, 19};

        // int[] rec1 = {5, 15, 8, 18};
        // int[] rec2 = {0, 3, 7, 9};

        int[] rec1 = {4, 0, 6, 6};
        int[] rec2 = {-5, -3, 4, 2};

        System.out.println(solution.isRectangleOverlap(rec1, rec2));
    }
}