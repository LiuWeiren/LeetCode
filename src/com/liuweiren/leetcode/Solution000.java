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
     * <a href="https://leetcode-cn.com/problems/string-to-integer-atoi">8.<a/>
     * String to Integer(atoi)(字符串转换整数 (atoi))
     *
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     *
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     *
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     *
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     *
     * 说明：
     *      假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。
     *      如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
     *
     * 示例 1:
     *      输入: "42"
     *      输出: 42
     *
     * 示例 2:
     *      输入: "   -42"
     *      输出: -42
     *      解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42。
     *
     * 示例 3:
     *      输入: "4193 with words"
     *      输出: 4193
     *      解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     *
     * 示例 4:
     *      输入: "words and 987"
     *      输出: 0
     *      解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     *      因此无法执行有效的转换。
     *
     * 示例 5:
     *      输入: "-91283472332"
     *      输出: -2147483648
     *      解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−231) 。
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int strLen = chars.length;
        int index = 0;
        /*
         * 跳过前面的空格
         */
        while (index < strLen) {
            if (chars[index] != ' ') {
                break;
            }

            index++;
        }
        /*
         * 若全部为空格，则返回0
         */
        if (index == strLen) {
            return 0;
        }
        /*
         * 判断第一个非空字符，并确定整数的符号
         */
        boolean isNegative;
        if (chars[index] == '+' || chars[index] >= '0' && chars[index] <= '9') {
            isNegative = false;
            if (chars[index] == '+') {
                index++;
            }
        } else if (chars[index] == '-') {
            isNegative = true;
            if (chars[index] == '-') {
                index++;
            }
        } else {
            return 0;
        }
        /*
         * 因为是32位环境，故不转为long，而是用int类型判断
         */
        int num = 0;
        // 避免前n位乘以10以后越界，无法判断
        int max = Integer.MAX_VALUE / 10;
        int maxMod = Integer.MAX_VALUE % 10;
        int minMod = Integer.MIN_VALUE % 10 * -1;
        for (int i = index; i < strLen; i++) {
            /*
             * 遇到非数字字符，结束循环
             */
            if (!(chars[i] >= '0' && chars[i] <= '9')) {
                break;
            }
            /*
             * 当当前数大于max时，再添加一位必然越界
             * 当当前数等于max时，如果个位大于minMod、maxMod（取决于是正数还是负数），再加一位必然越界
             */
            if (num > max ||
                    num == max && (isNegative && chars[i] - '0' > minMod
                            || !isNegative && chars[i] - '0' > maxMod)) {
                num = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                break;
            }

            num = num * 10 + (chars[i] - '0');
        }

        if (num !=  Integer.MIN_VALUE) {
            num = isNegative ? -num : num;
        }

        return num;
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
