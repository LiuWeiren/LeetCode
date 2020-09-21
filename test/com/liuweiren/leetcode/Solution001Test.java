package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution001Test {

    Solution001 solution = new Solution001();

    @Test
    void longestCommonPrefix() {
        String[][] strings = {
                { "flower", "flow", "flight" },
                { "dog", "racecar", "car" },
                { "" },
                { "flower" },
                { "aa", "a" }
        };

        for (String[] strs : strings) {
            System.out.println(solution.longestCommonPrefix(strs));
        }

        System.out.println(solution.longestCommonPrefix(new String[] { }));
    }
}