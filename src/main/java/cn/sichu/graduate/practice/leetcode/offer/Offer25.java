package cn.sichu.graduate.practice.leetcode.offer;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * 
 * @author sichu
 * @date 2022/06/02
 */
public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
