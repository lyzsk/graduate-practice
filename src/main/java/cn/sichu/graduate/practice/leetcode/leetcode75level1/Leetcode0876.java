package cn.sichu.graduate.practice.leetcode.leetcode75level1;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * @author sichu
 * @date 2022/07/03
 */
public class Leetcode0876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
