package com.liuweiren.leetcode;

import java.util.HashMap;

/**
 *
 * 1 - 9
 *
 * <br><br>Created by <b>LWR</b> on <b>2020/3/18</b>
 * @author LWR
 */
public class Solution000 {
    /**
     * 1.Two Sum(两数之和)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // /*
        //  * 暴力循环法
        //  */
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[j] == target - nums[i]) {
        //             return new int[] {i, j};
        //         }
        //     }
        // }
        //
        // return new int[] {};

        int length = nums.length;
        // 值, 下标
        HashMap<Integer, Integer> map = new HashMap<>(length, 1);

        for (int i = 0; i < length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[] {map.get(result), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    /**
     *  2. Add Two Numbers(两数相加)
     *
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
         * 递归
         */
        // 递归结束条件
        if (l1 == null && l2 == null) {
            return null;
        }
        /*
         * 若两个链表长度不同,则将其一位一位用0补齐
         * 例:
         *      l1 = 1->2->3->4
         *      l2 = 1->2
         *  通过迭代,l2可补齐为
         *      l2 = 1->2->0->0
         */
        if (l1 == null) {
            l1 = new ListNode(0);
        } else if (l2 == null) {
            l2 = new ListNode(0);

        }
        /*
         * 若当前位相加>=10,则将进位添加到l1.next.val(即下一个结点值+1)中
         */
        int resultVal = l1.val + l2.val;
        if (resultVal >= 10) {
            if (l1.next == null) {
                l1.next = new ListNode(0);
            }

            l1.next.val += resultVal /10;
            resultVal = resultVal % 10;
        }

        ListNode result = new ListNode(resultVal);
        result.next = addTwoNumbers(l1.next, l2.next);

        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 3.Longest Substring Without Repeating Characters(无重复字符的最长子串)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        /*
         * 滑动窗口
         */
        int maxLength = 0;
        int length = s.length();
        int i = 0;
        for (int j = 0; j < length; j++) {
            // 默认为[i, j]的长度
            int tempMax = j + 1 - i;
            int index = s.indexOf(s.charAt(j), i);
            if ( index < j && index >= 0 ) {
                i = index + 1;
                // [i, j] -> [i, j)，左闭合，右闭合 -> 左闭合，右开
                tempMax -= 1;
            }

            maxLength = Math.max(maxLength, tempMax);
        }

        return maxLength;
    }

    /**
     * 7.Reverse Integer(整数反转)
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        /*
         * 借用long来处理溢出情况
         */
        // if (x == Integer.MIN_VALUE) {
        //     return 0;
        // }
        //
        // boolean isNegative = x < 0;
        //
        // x = Math.abs(x);
        //
        // long num = 0;
        //
        // while (x >= 10) {
        //     num = num * 10 + x % 10;
        //     x = x / 10;
        // }
        // num = num * 10 + x % 10;
        //
        // if (isNegative) {
        //     num = - num;
        // }
        //
        // if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
        //     return 0;
        // }
        //
        // return (int) num;

        long num = 0;
        while (x != 0) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        return (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) ? 0 : (int) num;
    }

    /**
     * 9.Palindrome Number(回文数)
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        // if (x < 0) { return false; }
        //
        // int[] per = new int[10];
        // int realLen = 0;
        // while (x != 0) {
        //     per[realLen] = x % 10;
        //     x /= 10;
        //
        //     if (x != 0) {
        //         realLen++;
        //     }
        // }
        //
        // for (int i = 0, halfLen = (int) Math.ceil((realLen + 1) / 2); i < halfLen; i++) {
        //     if (per[i] != per[realLen - i]) {
        //         return false;
        //     }
        // }
        //
        // return true;

        // 小于0、以0为结尾的不是回文数
        if (x < 0 || x % 10 == 0 && x != 0) { return false; }
        /*
         * 低位整数反转，截取整数位数的一半
         */
        int perNum = 0;
        while (x > perNum) {
            perNum = perNum * 10 + x % 10;
            x /= 10;
        }
        // 原整数位数为偶数、整数位数为奇数（奇数位不影响回文数）则模10再比较
        return x == perNum || x == perNum / 10;
    }
}
