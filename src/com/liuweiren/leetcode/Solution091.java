package com.liuweiren.leetcode;

/**
 *
 * 910 - 919
 *
 * <br><br>created by <b>LWR</b> on <b>2020/3/27</b>
 * @author LWR
 */
public class Solution091 {
    /**
     * <a href="https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/">914.<a/>
     * X of a Kind in a Deck of Cards(卡牌分组)
     *
     * 给定一副牌，每张牌上都写着一个整数。
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     *      每组都有 X 张牌。
     *      组内所有的牌上都写着相同的整数。
     *      仅当你可选的 X >= 2 时返回 true。
     *
     * 示例 1：
     *      输入：[1,2,3,4,4,3,2,1]
     *      输出：true
     *      解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
     *
     * 示例 2：
     *      输入：[1,1,1,2,2,2,3,3]
     *      输出：false
     *      解释：没有满足要求的分组。
     *
     * 示例 3：
     *      输入：[1]
     *      输出：false
     *      解释：没有满足要求的分组。
     *
     * 示例 4：
     *      输入：[1,1]
     *      输出：true
     *      解释：可行的分组是 [1,1]
     *
     * 示例 5：
     *      输入：[1,1,2,2,2,2]
     *      输出：true
     *      解释：可行的分组是 [1,1]，[2,2]，[2,2]
     *
     * 提示：
     *      1 <= deck.length <= 10000
     *      0 <= deck[i] < 10000
     *
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        // 不符合条件的直接返回false
        if (deck == null || deck.length < 2) { return false; }
        // /*
        //  基本思想：要能实现分组，X应为每个数的约数，即X为所有数的公约数（且X>1）
        //  */
        // Map<Integer, Integer> cardMap = new HashMap<>(deck.length, 1);
        // /*
        //  * 统计每种牌的数量，并找出数量最少的那张牌
        //  */
        // for (int card : deck) {
        //     cardMap.put(card, cardMap.containsKey(card) ? cardMap.get(card) + 1 : 1);
        // }
        // /*
        //  * 求所有数的最大公约数
        //  */
        // int gcdNum = 0;
        // for (Integer count : cardMap.values()) {
        //     if (gcdNum == 0) {
        //         gcdNum = count;
        //     }
        //
        //     gcdNum = gcd(count, gcdNum);
        // }
        //
        // return gcdNum > 1;

        /*
         数组的方法
         */
        int[] counts = new int[10000];
        for (int card : deck) {
            counts[card]++;
        }

        int gcdCard = 0;
        for (int count : counts) {
            if (count > 0) {
                if (gcdCard == 0) {
                    gcdCard = count;
                }

                gcdCard = gcd(count, gcdCard);
            }
        }

        return gcdCard > 1;
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int m = x % y;
            x = y;
            y = m;
        }

        return x;
    }
}
