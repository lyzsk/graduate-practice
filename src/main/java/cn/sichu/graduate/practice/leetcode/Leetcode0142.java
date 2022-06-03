package cn.sichu.graduate.practice.leetcode;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * 
 * @author sichu
 * @date 2022/06/01
 */
public class Leetcode0142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (!hasCycle && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            hasCycle = fast == slow;
        }
        if (!hasCycle) {
            return null;
        }
        ListNode node = head;
        while (node != slow) {
            node = node.next;
            slow = slow.next;
        }
        return node;
    }
}
