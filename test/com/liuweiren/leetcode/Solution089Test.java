package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution089Test {

    Solution089 solution = new Solution089();

    @Test
    void surfaceArea() {
        int[][][] grids = {
                {{2}},
                {{1, 2}, {3, 4}},
                {{1, 0}, {0, 2}},
                {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}},
                {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}
        };

        for (int[][] grid : grids) {
            System.out.println(solution.surfaceArea(grid));
        }
    }
}