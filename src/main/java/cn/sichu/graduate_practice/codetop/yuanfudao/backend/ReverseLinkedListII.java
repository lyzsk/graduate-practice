package cn.sichu.graduate_practice.codetop.yuanfudao.backend;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * backend 频率2
 * <p>
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 
 * @author sichu
 * @date 2022/05/04
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
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode postHead = rightNode.next;

        // 断开连接
        pre.next = null;
        rightNode.next = null;

        reverse(leftNode);

        // 重新连接
        pre.next = rightNode;
        leftNode.next = postHead;

        return dummy.next;
    }

    private static void reverse(ListNode head) {
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
