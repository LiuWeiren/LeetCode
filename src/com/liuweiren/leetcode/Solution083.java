package com.liuweiren.leetcode;

/**
 *
 * 830 - 839
 *
 * <br><br>Created by <b>LWR</b> on <b>2020/3/18</b>
 * @author LWR
 */
public class Solution083 {

    /**
     * 836.Rectangle Overlap(矩形重叠)
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // /*
        //  * 保证rec1在左边或者是上边
        //  */
        // if (rec2[2] <= rec1[0] || rec2[1] >= rec1[3]) {
        //     for (int i = 0; i < rec1.length; i++) {
        //         rec1[i] = rec1[i] ^ rec2[i];
        //         rec2[i] = rec1[i] ^ rec2[i];
        //         rec1[i] = rec1[i] ^ rec2[i];
        //     }
        // }
        //
        // return rec1[2] > rec2[0] && rec1[1] < rec2[3];


        return !( rec1[3] <= rec2[1] || rec1[2] <= rec2[0] || rec1[1] >= rec2[3] || rec1[0] >= rec2[2] );

        // 投影法
        // return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])
        //         && Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }
}
