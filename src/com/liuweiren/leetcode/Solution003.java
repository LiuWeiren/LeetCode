package com.liuweiren.leetcode;
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
}
