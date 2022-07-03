package cn.sichu.graduate.practice.leetcode.leetcode75level1;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * @author sichu
 * @date 2022/07/03
 */
public class Leetcode0021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
