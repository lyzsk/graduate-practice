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

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode nextStart = end.next;

            end.next = null;
            pre.next = reverse(start);
            start.next = nextStart;

            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
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
