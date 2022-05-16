package cn.sichu.graduate_practice.codetop;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * 频率5
 * <p>
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 
 * @author sichu
 * @date 2022/05/05
 */
public class ReverseNodesInKGroup {
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
            slow.next = reverse(start);
            start.next = nextStart;

            slow = start;
            fast = start;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
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
