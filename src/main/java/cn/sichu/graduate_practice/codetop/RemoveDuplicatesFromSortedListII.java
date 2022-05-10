package cn.sichu.graduate_practice.codetop;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * 频率41
 * <p>
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * @author sichu
 * @date 2022/05/09
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
