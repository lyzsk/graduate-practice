package cn.sichu.graduate.practice.leetcode;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * 
 * @author sichu
 * @date 2022/05/25
 */
public class Leetcode0092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode leftEnd = dummy;
        for (int i = 0; i < left - 1; i++) {
            leftEnd = leftEnd.next;
        }
        ListNode leftNode = leftEnd.next;
        ListNode rightNode = leftNode;
        for (int i = 0; i < right - left; i++) {
            rightNode = rightNode.next;
        }
        ListNode rightStart = rightNode.next;

        rightNode.next = null;
        leftEnd.next = reverseList(leftNode);
        leftNode.next = rightStart;
        return dummy.next;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null) {
            ListNode tmp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = tmp;
        }
        return slow;
    }
}
