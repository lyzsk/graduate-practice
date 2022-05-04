package cn.sichu.graduate_practice.codetop;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * https://codetop.cc/home 频率1
 * <p>
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 
 * @author sichu
 * @date 2022/05/04
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
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
