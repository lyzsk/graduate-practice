package cn.sichu.graduate.practice.leetcode;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * @author sichu
 * @date 2022/06/27
 */
public class Leetcode0024 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            cur = node1;
        }
        return dummy.next;
    }
}
