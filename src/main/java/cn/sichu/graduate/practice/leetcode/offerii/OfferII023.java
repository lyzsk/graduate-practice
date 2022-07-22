package cn.sichu.graduate.practice.leetcode.offerii;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * @author sichu
 * @date 2022/07/22
 */
public class OfferII023 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
