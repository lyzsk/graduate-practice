package cn.sichu.graduate.practice.leetcode.leetcode75level1;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * @author sichu
 * @date 2022/07/03
 */
public class Leetcode0206 {
    public ListNode reverseList(ListNode head) {
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
