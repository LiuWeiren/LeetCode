package com.liuweiren.leetcode;
/**
 *
 * 10 - 19
 *
 * <br><br>created by <b>LWR</b> on <b>2020/9/21</b>
 * @author LWR
 * @date 2020/9/21
 */
public class Solution001 {
    /**
     * <a href="https://leetcode-cn.com/problems/longest-common-prefix/">14.</a>
     * Longest Common Prefix(最长公共前缀)
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String str0 = strs[0];
        for (int i = 0, length = str0.length(); i < length; i++) {
            char currentChar = str0.charAt(i);
            for (String str : strs) {
                if (i == str.length() || str.charAt(i) != currentChar) {
                    return str0.substring(0, i);
                }
            }
        }

        return str0;

        // int strCount = strs.length;
        //
        // if (strCount == 0) { return ""; }
        //
        // int maxIndex = 0;
        // String firstStr = strs[0];
        //
        // for (int i = 0; i < firstStr.length() ; i++) {
        //     int sameCount = 0;
        //     char sameChar = firstStr.charAt(i);
        //
        //     for (String str : strs) {
        //         // 防下标越界
        //         if (i < str.length() && str.charAt(i) == sameChar) {
        //             sameCount++;
        //         } else {
        //             break;
        //         }
        //     }
        //
        //     if (sameCount != strCount) break;
        //
        //     maxIndex++;
        // }
        //
        // return maxIndex == 0 ? "" : strs[0].substring(0, maxIndex);
    }
}
