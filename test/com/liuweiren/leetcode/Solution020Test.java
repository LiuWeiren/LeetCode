package com.liuweiren.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution020Test {

    Solution020 solution = new Solution020();

    @Test
    void reverseList() {
        int[] vals = {1, 2, 3, 4, 5};

        Solution020.ListNode head = solution.new ListNode(vals[0]);
        Solution020.ListNode head2 = solution.new ListNode(vals[1]);
        head.next = head2;
        Solution020.ListNode head3 = solution.new ListNode(vals[2]);
        head2.next = head3;
        Solution020.ListNode head4 = solution.new ListNode(vals[3]);
        head3.next = head4;
        head4.next = solution.new ListNode(vals[4]);

        // while (head != null) {
        //     System.out.println(head.val);
        //     head = head.next;
        // }


        Solution020.ListNode node = solution.reverseList(head);
    }
}