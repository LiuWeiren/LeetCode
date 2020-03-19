package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution040Test {
    
    Solution040 solution = new Solution040();

    @Test
    void longestPalindrome() {

        // String s = "";
        // String s = "a";
        // String s = "abccccdd";
        String s = "AabbcccccdddZz";

        System.out.println(solution.longestPalindrome(s));
    }
}