package cn.sichu.graduate.practice.leetcode.offer;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * 
 * @author sichu
 * @date 2022/06/01
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
