package com.liuweiren.leetcode;
/**
 *
 * 面试题：10 - 19
 *
 * <br><br>created by <b>LWR</b> on <b>2020/3/24</b>
 * @author LWR
 */
public class SolutionInterview010 {
    /**
     * <a href="https://leetcode-cn.com/problems/the-masseuse-lcci">17.16.<a/>
     * The Masseuse LCCI(按摩师)
     *
     * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
     * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
     *
     * 注意：本题相对原题稍作改动
     *
     * 示例 1：
     *      输入： [1,2,3,1]
     *      输出： 4
     *      解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
     *
     * 示例 2：
     *      输入： [2,7,9,3,1]
     *      输出： 12
     *      解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
     *
     * 示例 3：
     *      输入： [2,1,4,5,3,1,1,3]
     *      输出： 12
     *      解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
     *
     * @param nums
     * @return
     */
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // /*
        // 动态规划：
        //
        // f(k) = 前k次预约中的最长总预约时间，nums[n]表示第n次预约的时间
        //
        // 首先 n = 1，f(1) = nums[1]；
        // 再看 n = 2，f(2) = max(nums[1], num[2])；
        // 当 n = 3时，有两个选项:
        //    抢第三个房子，将数额与第一个房子相加。
        //    不抢第三个房子，保持现有最大数额。
        // 显然，你想选择数额更大的选项。于是，可以总结出公式：
        //     f(n) = max(f(n-1), f(n-2) + num[n])
        //
        //
        // 复杂度分析：
        //     时间复杂度：O(n)，其中n为预约的个数。我们有2n个状态需要计算，每次状态转移需要O(1)的时间，所以一共需要 O(2n)=O(n)的时间复杂度。
        //     空间复杂度：O(n)，存放f(k)结果的数组的空间。
        //  */
        // int numsLen = nums.length;
        //
        // if (numsLen == 1) { return nums[0]; }
        //
        // int[] result = new int[numsLen];
        // result[0] = nums[0];
        // result[1] = Math.max(nums[0], nums[1]);
        //
        // for (int i = 2; i < numsLen; i++) {
        //     result[i] = Math.max(result[i-1], result[i-2] + nums[i]);
        // }
        //
        // return result[numsLen - 1];

        /*
        动态规划：
            思想同上，只不过将f(k-1)，f(k-2)的结果由数组改为两个变量表示（因为只需要结果，不需要知道其是怎么来的）

        复杂度分析：
            时间复杂度：O(n)，其中n为预约的个数。我们有2n个状态需要计算，每次状态转移需要O(1)的时间，所以一共需要 O(2n)=O(n)的时间复杂度。
            空间复杂度：O(1)，存放常量的空间。
         */
        int pre = 0;
        int cur = 0;
        for (int num : nums) {
            int temp = cur;
            cur = Math.max(temp, pre + num);
            pre = temp;
        }

        return cur;
    }
}
