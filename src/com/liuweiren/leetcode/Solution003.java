package com.liuweiren.leetcode;

import java.util.Arrays;

/**
 *
 * 30 -39
 *
 * <br><br>created by <b>LWR</b> on <b>2020/9/19</b>
 * @author LWR
 * @date 2020/9/19
 */
public class Solution003 {
    /**
     * <a href="https://leetcode-cn.com/problems/search-insert-position/">35.</a>
     * Search Insert Position(搜索插入位置)
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {

        /*
         * 二分查找
         */
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] >= target) {
        //         return i;
        //     }
        // }
        //
        // return nums.length;
    }

    /**
     * <a href="https://leetcode-cn.com/problems/count-and-say/">38.</a>
     * Count And Say(外观数列)
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {

        /*
         * 操作数组的方法
         */
        int[] arr = {1};

        while (n > 1) {
            int len = arr.length;
            // 一个数字需要两个数字描述，当前长度最多是前一个数组长度的2倍
            int[] ansArr = new int[len * 2];
            // 连续相同数字的个数
            int sameCount = 0;
            // 当前数组的下标
            int ansIndex = 0;

            // index下的表示数字的个数，index+1下的表示数字
            ansArr[ansIndex + 1] = arr[0];
            // 遍历上一个数组
            for (int i = 0; i < len; i++) {
                if (i == 0 || arr[i] == arr[i-1]) {
                    // 和前一个数字相同的 +1
                    sameCount += 1;
                } else {
                    // 不同的，保存统计到数字的个数，并移动当前数组下标至下两位
                    ansArr[ansIndex] = sameCount;
                    ansIndex += 2;
                    ansArr[ansIndex + 1] = arr[i];

                    sameCount = 1;
                }

                // 遍历到最后一位，直接保存
                if (i == len - 1) {
                    ansArr[ansIndex] = sameCount;
                }
            }

            // 截取当前数组保存，长度为 index + 2
            arr = Arrays.copyOf(ansArr, ansIndex + 2);

            n--;
        }

        StringBuilder ansBuilder = new StringBuilder();
        for (int num : arr) {
            ansBuilder.append(num);
        }

        return ansBuilder.toString();
    }
}
