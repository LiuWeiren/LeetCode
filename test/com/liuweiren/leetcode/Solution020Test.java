package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution020Test {

    Solution020 solution = new Solution020();

    @Test
    void reverseList() {
        int[] vals = {1, 2, 3, 4, 5};

        Solution020.ListNode head = solution.new ListNode(vals[0]);
        Solution020.ListNode headTemp = head;
        for (int i = 1; i < vals.length; i++) {
            headTemp.next = solution.new ListNode(vals[i]);
            headTemp = headTemp.next;
        }

        Solution020.ListNode node = solution.reverseList(head);
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }
}