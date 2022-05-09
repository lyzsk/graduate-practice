package cn.sichu.graduate_practice.medium;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * https://leetcode.cn/problems/merge-in-between-linked-lists/
 * 
 * @author sichu
 * @date 2022/05/08
 */
public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode();
        dummy.next = list1;

        ListNode cur = dummy;
        for (int i = 0; i < a; i++) {
            cur = cur.next;
        }

        ListNode rightNode = cur;
        for (int i = 0; i < b - a + 1; i++) {
            rightNode = rightNode.next;
        }
        ListNode postHead = rightNode.next;

        ListNode tmp = list2;
        while (tmp.next != null) {
            tmp = tmp.next;
        }

        cur.next = list2;
        tmp.next = postHead;

        return dummy.next;
    }
}
