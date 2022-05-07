package cn.sichu.graduate_practice.codetop;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * 频率18
 * <p>
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 
 * @author sichu
 * @date 2022/05/06
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // if (headA == null || headB == null) {
        // return null;
        // }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
