package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionInterview010Test {

    SolutionInterview010 solution = new SolutionInterview010();

    @Test
    void massage() {
        int[][] numsArr = {
                {1, 2, 3, 1},
                {2, 7, 9, 3, 1},
                {2, 1, 4, 5, 3, 1, 1, 3}
        };

        for (int[] nums: numsArr) {
            System.out.println(solution.massage(nums));
        }
    }
}