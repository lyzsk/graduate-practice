package cn.sichu.graduate.practice.leetcode;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * 
 * @author sichu
 * @date 2022/05/25
 */
public class Leetcode0143 {
    public void reorderList(ListNode head) {
        ListNode mid = midlleNode(head);
        ListNode l2Start = mid.next;
        mid.next = null;
        ListNode l2 = reverseList(l2Start);
        ListNode l1 = head;
        mergeList(l1, l2);
    }

    private static ListNode midlleNode(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

    private static void mergeList(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;
            l1.next = l2;
            l1 = tmp1;
            l2.next = l1;
            l2 = tmp2;
        }
    }
}
