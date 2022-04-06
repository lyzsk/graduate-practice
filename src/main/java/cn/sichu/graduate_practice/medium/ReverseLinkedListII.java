package cn.sichu.graduate_practice.medium;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 
 * @author sichu
 * @date 2022/04/05
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = left; i < right + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverse(leftNode);

        pre.next = rightNode;
        leftNode.next = cur;

        return dummy.next;
    }

    private void reverse(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;

        while (fast != null) {
            ListNode tmp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = tmp;
        }
    }

}
