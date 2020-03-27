package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution091Test {

    Solution091 solution = new Solution091();

    @Test
    void hasGroupsSizeX() {
        int[][] decks = {
                {1, 2, 3, 4, 4, 3, 2, 1},
                {1, 1, 1, 2, 2, 2, 3, 3},
                {1},
                {1, 1},
                {1, 1, 2, 2, 2, 2}, 
                {},
                {1, 1, 1, 1, 2, 2, 2, 2, 2, 2},
                {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };

        for (int[] deck : decks) {
            System.out.println(solution.hasGroupsSizeX(deck));
        }
    }
}