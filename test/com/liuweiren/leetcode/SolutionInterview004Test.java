package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionInterview004Test {

    SolutionInterview004 solution = new SolutionInterview004();

    @Test
    void getLeastNumbers() {
        int[] arr = {3,2,1};
        int k = 2;

        System.out.println(Arrays.toString(solution.getLeastNumbers(arr, k)));
    }
}