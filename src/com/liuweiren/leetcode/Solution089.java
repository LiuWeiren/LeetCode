package com.liuweiren.leetcode;
/**
 *
 * 890 - 899
 *
 * <br><br>created by <b>LWR</b> on <b>2020/3/26</b>
 * @author LWR
 */
public class Solution089 {
    /**
     * <a href="https://leetcode-cn.com/problems/surface-area-of-3d-shapes">892.<a/>
     * Surface Area of 3D Shapes(三维形体的表面积)
     *
     * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
     * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
     * 请你返回最终形体的表面积。
     *
     * 示例 1：
     *      输入：[[2]]
     *      输出：10
     *
     * 示例 2：
     *      输入：[[1,2],[3,4]]
     *      输出：34
     *
     * 示例 3：
     *      输入：[[1,0],[0,2]]
     *      输出：16
     *
     * 示例 4：
     *      输入：[[1,1,1],[1,0,1],[1,1,1]]
     *      输出：32
     *
     * 示例 5：
     *      输入：[[2,2,2],[2,1,2],[2,2,2]]
     *      输出：46
     *
     * 提示：
     *      1 <= N <= 50
     *      0 <= grid[i][j] <= 50
     *
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        /*
         * 把每一格的立方体的组合看成是直棱柱，
         * 先计算组成的直棱柱的表面积，再减去此直棱柱x轴上和y轴上被覆盖的面积
         */
        int len = grid.length;
        int area = 0;
        // i是y轴
        for (int i = 0; i < len; i++) {
            // j是x轴
            for (int j = 0; j < len; j++) {
                int height = grid[i][j];
                if (height > 0) {
                    // 计算此直棱柱的表面积
                    area += (height * 4) + 2;
                    // 计算直棱柱y轴上被覆盖的面积（只计算与前面重合的部分）
                    area -= i > 0? Math.min(height, grid[i - 1][j]) * 2: 0;
                    // 计算直棱柱x轴上被覆盖的面积（只计算与前面重合的部分）
                    area -= j > 0? Math.min(height, grid[i][j - 1]) * 2: 0;
                }
            }
        }

        return area;
    }
}
