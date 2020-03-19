package com.liuweiren.leetcode;

/**
 *
 * 400 - 409
 *
 * <br><br>Created by <b>LWR</b> on <b>2020/3/19</b>
 * @author LWR
 */
public class Solution040 {
    /**
     * 409.Longest Palindrome(最长回文串)
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        /*
         * 使用数组的方式
         */
        int maxLen = 0;
        boolean hasSingle = false;
        // 26个字母大小写 + 中间的6个字符
        int[] letterSums = new int[58];
        // 统计每个字母出现的次数
        for (char c: s.toCharArray()) {
            letterSums[c - 'A']++;
        }

        for (int letterSum : letterSums) {
            if (letterSum == 0) { continue;}
            /*
             * 字母数是偶数个,直接加
             * 字母数是奇数个,取最大偶数
             */
            if (letterSum % 2 == 0) {
                maxLen += letterSum;
            } else {
                maxLen += letterSum - 1;
                hasSingle = true;
            }
        }
        // 字母数为奇数个的字母,最多允许存在一个
        return hasSingle ? maxLen + 1 : maxLen;

        // /*
        //  * 使用集合的方式
        //  */
        // int maxLen = 0;
        // boolean hasSingle = false;
        //
        // Map<Character, Integer> letterMap = new HashMap<>(52, 1);
        // for (char c : s.toCharArray()) {
        //     letterMap.put(c, letterMap.get(c) == null ? 1 : letterMap.get(c) + 1);
        // }
        //
        // for (int sum : letterMap.values()) {
        //     if (sum == 0) { continue; }
        //
        //     if (sum % 2 == 0) {
        //         maxLen += sum;
        //     } else {
        //         maxLen += sum - 1;
        //         hasSingle = true;
        //     }
        // }
        //
        // return hasSingle ? maxLen + 1 : maxLen;

        // /*
        //  * 官方题解
        //  */
        // int[] count = new int[128];
        // for (char c: s.toCharArray())
        //     count[c]++;
        //
        // int ans = 0;
        // for (int v: count) {
        //     ans += v / 2 * 2;
        //     if (v % 2 == 1 && ans % 2 == 0)
        //         ans++;
        // }
        // return ans;
    }
}
