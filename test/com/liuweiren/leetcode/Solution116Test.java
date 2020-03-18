package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution116Test {

    Solution116 solution = new Solution116();

    @Test
    void countCharacters() {
        // String[] words = {"cat","bt","hat","tree"};
        // String chars = "atach";

        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";

        int result = solution.countCharacters(words, chars);

        System.out.println(result);
    }
}