package cn.sichu.graduate_practice.interview;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 * 
 * @author sichu
 * @date 2022/05/01
 */
public class Interview0206 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow.next;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }

        return true;
    }
}
