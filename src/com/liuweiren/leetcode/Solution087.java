package com.liuweiren.leetcode;

/**
 *
 * 870 - 879
 *
 * <br><br>created by <b>LWR</b> on <b>2020/3/23</b>
 * @author LWR
 */
public class Solution087 {
    /**
     * <a href="https://leetcode-cn.com/problems/middle-of-the-linked-list">876.<a/>
     * Middle of the Linked List(链表的中间结点)
     *
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     * 示例 1：
     *      输入：[1,2,3,4,5]
     *      输出：此列表中的结点 3 (序列化形式：[3,4,5])
     *      返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     *      注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     *          ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     *
     * 示例 2：
     *      输入：[1,2,3,4,5,6]
     *      输出：此列表中的结点 4 (序列化形式：[4,5,6])
     *      由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     *
     * 提示：
     *      给定链表的结点数介于 1 和 100 之间。
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        if (head == null) {
            return null;
        }

        // /*
        // 数组的方法，先遍历一遍链表，将节点保存到数组中，再通过下标获取
        //
        // 复杂度分析：
        //     时间复杂度：O(N)，其中N是给定链表中的结点数目。
        //     空间复杂度：O(N)，即数组nodeList用去的空间。
        //  */
        // List<ListNode> nodeList = new ArrayList<>();
        //
        // while (head != null) {
        //     nodeList.add(head);
        //     head = head.next;
        // }
        //
        // return nodeList.get(nodeList.size() / 2);

        // /*
        // 单指针法，先遍历一遍链表，记录链表的长度N，第二次只需遍历到N/2即可
        //
        // 复杂度分析：
        //     时间复杂度：O(N)，其中 N 是给定链表的结点数目。
        //     空间复杂度：O(1)，只需要常数空间存放变量和指针。
        //  */
        // ListNode origin = head;
        // int len = 0;
        // while (head != null) {
        //     len++;
        //     head = head.next;
        // }
        //
        // head = origin;
        // int k = 0;
        // while (k < len / 2) {
        //     k++;
        //     head = head.next;
        // }
        //
        // return head;

        /*
        快慢指针法，

        复杂度分析：
            时间复杂度：O(N)，其中 N 是给定链表的结点数目。
            空间复杂度：O(1)，只需要常数空间存放 slow 和 fast 两个指针。
         */
        ListNode show = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            show = show.next;
            fast = fast.next.next;
        }

        return show;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
