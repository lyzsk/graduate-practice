package cn.sichu.graduate.practice.leetcode.offer;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class Offer24 {
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
