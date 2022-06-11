package cn.sichu.graduate.practice.leetcode.tencent50;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * 
 * @author sichu
 * @date 2022/06/10
 */
public class Tencent21 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode tail = null;
        for (ListNode p = head; p != null; p = p.next) {
            tail = p;
            ++len;
        }
        k %= len;
        ListNode p = head;
        for (int i = 0; i < len - k - 1; i++) {
            p = p.next;
        }
        tail.next = head;
        head = p.next;
        p.next = null;
        return head;
    }
}
