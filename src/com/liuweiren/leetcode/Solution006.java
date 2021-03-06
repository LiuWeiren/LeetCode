package com.liuweiren.leetcode;
/**
 *
 * 60 - 69
 *
 * <br><br>created by <b>LWR</b> on <b>2020/9/18</b>
 * @author LWR
 * @date 2020/9/18
 */
public class Solution006 {
    /**
     * <a href="https://leetcode-cn.com/problems/sqrtx/">69.</a>
     * Sqrt(x)(x 的平方根)
     *
     * 实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     *      输入: 4
     *      输出: 2
     *
     * 示例 2:
     *      输入: 8
     *      输出: 2
     *      说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
