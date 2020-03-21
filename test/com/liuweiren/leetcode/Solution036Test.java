package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution036Test {

    Solution036 solution = new Solution036();

    @Test
    void canMeasureWater() {
        // int x = 0, y = 0, z = 0;
        // int x = 0, y = 0, z = 1;
        // int x = 3, y = 5, z = 4;
        int x = 2, y = 6, z = 5;

        System.out.println(solution.canMeasureWater(x, y, z));
    }
}