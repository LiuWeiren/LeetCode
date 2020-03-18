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

    @Test
    void reverse() {
        int x = -2147483648;
        int y = 2147483647;
        int z = 123;
        int a = 0;
        int b = -123;
        int c = 120;
        int d = -120;

        System.out.println(solution.reverse(x));
        System.out.println(solution.reverse(y));
        System.out.println(solution.reverse(z));
        System.out.println(solution.reverse(a));
        System.out.println(solution.reverse(b));
        System.out.println(solution.reverse(c));
        System.out.println(solution.reverse(d));
    }

    @Test
    void isPalindrome() {
        int x = 121;
        int y = 123;
        int z = -123321;
        int a = 123321;
        int b = 0;
        int c = 8;
        int d = 10;

        System.out.println(solution.isPalindrome(x));
        System.out.println(solution.isPalindrome(y));
        System.out.println(solution.isPalindrome(z));
        System.out.println(solution.isPalindrome(a));
        System.out.println(solution.isPalindrome(b));
        System.out.println(solution.isPalindrome(c));
        System.out.println(solution.isPalindrome(d));
    }
}