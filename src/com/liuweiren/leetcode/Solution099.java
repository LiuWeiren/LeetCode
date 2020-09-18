package com.liuweiren.leetcode;
/**
 *
 * 990 - 999
 *
 * <br><br>created by <b>LWR</b> on <b>2020/3/26</b>
 * @author LWR
 */
public class Solution099 {
    /**
     * <a href="https://leetcode-cn.com/problems/available-captures-for-rook">999.<a/>
     * Available Captures for Rook(车的可用捕获量)
     *
     * 在一个8x8的棋盘上，有一个白色车（rook）。
     * 也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
     * 它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
     *
     * 车按国际象棋中的规则移动：
     *      它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，
     *      直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
     *      另外，车不能与其他友方（白色）象进入同一个方格。
     *
     * 返回车能够在一次移动中捕获到的卒的数量。
     *
     * 示例 1：
     *      输入：[
     *              [".",".",".",".",".",".",".","."],
     *              [".",".",".","p",".",".",".","."],
     *              [".",".",".","R",".",".",".","p"],
     *              [".",".",".",".",".",".",".","."],
     *              [".",".",".",".",".",".",".","."],
     *              [".",".",".","p",".",".",".","."],
     *              [".",".",".",".",".",".",".","."],
     *              [".",".",".",".",".",".",".","."]
     *           ]
     *      输出：3
     *      解释：
     *          在本例中，车能够捕获所有的卒。
     *
     * 示例 2：
     *      输入：[
     *              [".",".",".",".",".",".",".","."],
     *              [".","p","p","p","p","p",".","."],
     *              [".","p","p","B","p","p",".","."],
     *              [".","p","B","R","B","p",".","."],
     *              [".","p","p","B","p","p",".","."],
     *              [".","p","p","p","p","p",".","."],
     *              [".",".",".",".",".",".",".","."],
     *              [".",".",".",".",".",".",".","."]
     *           ]
     *      输出：0
     *      解释：
     *          象阻止了车捕获任何卒。
     *
     * 示例 3：
     *      输入：[
     *              [".",".",".",".",".",".",".","."],
     *              [".",".",".","p",".",".",".","."],
     *              [".",".",".","p",".",".",".","."],
     *              ["p","p",".","R",".","p","B","."],
     *              [".",".",".",".",".",".",".","."],
     *              [".",".",".","B",".",".",".","."],
     *              [".",".",".","p",".",".",".","."],
     *              [".",".",".",".",".",".",".","."]
     *           ]
     *      输出：3
     *      解释：
     *          车可以捕获位置 b5，d6 和 f5 的卒。
     *
     * 提示：
     *      board.length == board[i].length == 8
     *      board[i][j] 可以是 'R'，'.'，'B' 或 'p'
     *      只有一个格子上存在 board[i][j] == 'R'
     *
     * @param board
     * @return
     */
    public int numRookCaptures(char[][] board) {
        if(board == null || board.length == 0) {
            return 0;
        }
        // /*
        //  先找出Rook的坐标，再在四个方向上遍历，需要边缘或者bishop则停止，遇到pawn则捕获
        //  */
        //
        // /*
        //  * Rook的位置：board[jRook][iRook]
        //  */
        // int iRook = -1;
        // int jRook = -1;
        // /*
        //  * 遍历数组，找到Rook的位置
        //  */
        // for (int j = 0, yLen = board.length ; j < yLen; j++) {
        //     boolean isRook = false;
        //     for (int i = 0, xLen = board[j].length; i < xLen; i++) {
        //         if (board[j][i] == 'R') {
        //             isRook = true;
        //             iRook = i;
        //             jRook = j;
        //             break;
        //         }
        //     }
        //
        //     if (isRook) { break; }
        // }
        // // 不存在返回0
        // if (iRook == -1) { return 0; }
        //
        // int count = 0;
        //
        // // 车的左边
        // for (int i = iRook - 1; i >= 0; i--) {
        //     char chess = board[jRook][i];
        //     if (chess == 'B') { break; }
        //     if (chess == 'p') {
        //         count++;
        //         break;
        //     }
        // }
        //
        // // 车的右边
        // for (int i = iRook + 1, xLen = board[jRook].length; i < xLen; i++) {
        //     char chess = board[jRook][i];
        //     if (chess == 'B') { break; }
        //     if (chess == 'p') {
        //         count++;
        //         break;
        //     }
        // }
        //
        // // 车的上边
        // for (int j = jRook - 1; j >= 0 ; j--) {
        //     char chess = board[j][iRook];
        //     if (chess == 'B') { break; }
        //     if (chess == 'p') {
        //         count++;
        //         break;
        //     }
        // }
        //
        // // 车的下边
        // for (int j = jRook + 1, yLen = board.length; j < yLen; j++) {
        //     char chess = board[j][iRook];
        //     if (chess == 'B') { break; }
        //     if (chess == 'p') {
        //         count++;
        //         break;
        //     }
        // }
        //
        // return count;

        /*
         思路同上，利用方向数组，以省去重复的代码
         */

        /*
         * 方向数组：左、右、上、下
         */
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};

        int rookX = -1;
        int rookY = -1;
        /*
         * 遍历数组，找到Rook的位置
         */
        for (int j = 0, yLen = board.length ; j < yLen; j++) {
            boolean isRook = false;
            for (int i = 0, xLen = board[j].length; i < xLen; i++) {
                if (board[j][i] == 'R') {
                    isRook = true;
                    rookX = i;
                    rookY = j;
                    break;
                }
            }

            if (isRook) { break; }
        }
        // 不存在返回0
        if (rookX == -1) { return 0; }
        /*
         * 棋盘大小
         */
        int boardLenX = board[rookY].length;
        int boardLenY = board.length;

        int count = 0;

        for (int i = 0; i < 4; i++) {
            for (int step = 0; ; step++) {
                /*
                 * 移动向量
                 */
                int stepX = rookX + step * dirX[i];
                int stepY = rookY + step * dirY[i];

                if (stepX < 0 || stepX >= boardLenX
                        || stepY < 0 || stepY >= boardLenY
                        || board[stepY][stepX] == 'B') {
                    break;
                }

                if (board[stepY][stepX] == 'p') {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

}
