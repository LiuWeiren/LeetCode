package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution001Test {

    Solution001 solution = new Solution001();

    @Test
    void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }

    @Test
    void addTwoNumbers() {

    }

    @Test
    void lengthOfLongestSubstring() {

    }
}