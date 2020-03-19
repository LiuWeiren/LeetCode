package com.liuweiren.leetcode;

/**
 *
 * 200 - 209
 *
 * <br><br>created by <b>LWR</b> on <b>2020/3/19</b>
 * @author LWR
 */
public class Solution020 {
    /**
     * <a href="https://leetcode-cn.com/problems/reverse-linked-list/">206.</a>
     *
     * Reverse Linked List(反转链表)
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // /*
        //  * 将链表转为数组，反转后再转为链表
        //  */
        // List<Integer> vals = new ArrayList<>();
        //
        // ListNode headTemp = head;
        // while (headTemp != null) {
        //     vals.add(headTemp.val);
        //     headTemp = headTemp.next;
        // }
        //
        // Collections.reverse(vals);
        //
        // headTemp = head;
        // for (int val : vals) {
        //     headTemp.val = val;
        //     headTemp = headTemp.next;
        // }
        //
        // return head;

        /*
         * 迭代
         */
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
