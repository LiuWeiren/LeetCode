package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution087Test {

    Solution087 solution = new Solution087();

    @Test
    void middleNode() {
        int[] nodeVal = {1, 2, 3, 4, 5, 6};
        Solution087.ListNode head = solution.new ListNode(nodeVal[0]);
        Solution087.ListNode headTemp = head;
        for (int i = 1; i < nodeVal.length; i++) {
            headTemp.next = solution.new ListNode(nodeVal[i]);
            headTemp = headTemp.next;
        }

        Solution087.ListNode result = solution.middleNode(head);
        while (result != null) {
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }
}