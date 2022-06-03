package cn.sichu.graduate.practice.leetcode.offer;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * 记得要加 break， 测试用例 [-3,5,-99]， -99，这种的不能让他继续判断cur.next.val了
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
