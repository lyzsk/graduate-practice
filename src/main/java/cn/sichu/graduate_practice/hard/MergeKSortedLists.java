package cn.sichu.graduate_practice.hard;

import java.util.PriorityQueue;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * 
 * @author sichu
 * @date 2022/05/18
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((o1, o2) -> o1.val - o2.val);
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                heap.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!heap.isEmpty()) {
            cur.next = heap.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

    /**
     * 用合并两两链表的方式，最快
     * 
     * @param lists
     * @return
     */
    public ListNode mergeKListsSolution2(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        while (len > 1) {
            for (int i = 0; i < len >> 1; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[len - 1 - i]);
            }
            len = (len + 1) >> 1;
        }
        return lists[0];
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
