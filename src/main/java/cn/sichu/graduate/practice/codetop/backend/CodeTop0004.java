package cn.sichu.graduate.practice.codetop.backend;

import cn.sichu.graduate.practice.codetop.utils.ListNode;

/**
 * 
 * @author sichu
 * @date 2022/05/20
 */
public class CodeTop0004 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next != null) {
            for (int i = 0; i < k && fast != null; i++) {
                fast = fast.next;
            }
            if (fast == null) {
                break;
            }
            ListNode start = slow.next;
            ListNode nextStart = fast.next;

            fast.next = null;
            slow.next = reverseList(start);
            start.next = nextStart;

            slow = start;
            fast = start;
        }
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
