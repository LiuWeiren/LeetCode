package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution099Test {

    Solution099 solution = new Solution099();

    @Test
    void numRookCaptures() {
        char[][][] boards = {
                {
                    {'.', '.', '.', '.', '.', '.', '.', '.'}, 
                    {'.', '.', '.', 'p', '.', '.', '.', '.'}, 
                    {'.', '.', '.', 'R', '.', '.', '.', 'p'}, 
                    {'.', '.', '.', '.', '.', '.', '.', '.'}, 
                    {'.', '.', '.', '.', '.', '.', '.', '.'}, 
                    {'.', '.', '.', 'p', '.', '.', '.', '.'}, 
                    {'.', '.', '.', '.', '.', '.', '.', '.'}, 
                    {'.', '.', '.', '.', '.', '.', '.', '.'}
                },
                {
                    {'.', '.', '.', '.', '.', '.', '.', '.'},
                    {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                    {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                    {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
                    {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                    {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.'}
                },
                {
                    {'.', '.', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', 'p', '.', '.', '.', '.'},
                    {'.', '.', '.', 'p', '.', '.', '.', '.'},
                    {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', 'B', '.', '.', '.', '.'},
                    {'.', '.', '.', 'p', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.'}
                }
        };

        for (char[][] board : boards) {
            System.out.println(solution.numRookCaptures(board));
        }
    }
}