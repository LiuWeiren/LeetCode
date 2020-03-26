package com.liuweiren.leetcode;

import java.util.Arrays;

/**
 *
 * 940 - 949
 *
 * <br><br>created by <b>LWR</b> on <b>2020/3/22</b>
 * @author LWR
 */
public class Solution094 {
    /**
     * <a href="https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/">945.<a/>
     * Minimum Increment to Make Array Unique(使数组唯一的最小增量)
     *
     * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
     * 返回使 A 中的每个值都是唯一的最少操作次数。
     *
     * 示例 1:
     *      输入：[1,2,2]
     *      输出：1
     *      解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
     *
     * 示例 2:
     *      输入：[3,2,1,2,1,7]
     *      输出：6
     *      解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
     *      可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
     *
     * 提示：
     *      1. 0 <= A.length <= 40000
     *      2. 0 <= A[i] < 40000
     *
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        Arrays.sort(A);

        System.out.println(Arrays.toString(A));

        int sum = 0;
        for (int i = 1, len = A.length; i < len; i++) {
            if (A[i] <= A[i-1]) {
                sum += A[i-1] - A[i] + 1;
                A[i] = A[i-1] + 1;
            }
        }

        System.out.println(Arrays.toString(A));

        return sum;
    }
}
