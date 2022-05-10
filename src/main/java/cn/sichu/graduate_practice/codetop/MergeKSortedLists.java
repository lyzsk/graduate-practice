package cn.sichu.graduate_practice.codetop;

import java.util.PriorityQueue;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * 频率24
 * <p>
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 
 * @author sichu
 * @date 2022/05/07
 */
public class MergeKSortedLists {
    class Status implements Comparable<Status> {
        private int val;
        private ListNode node;

        public Status(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    private PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                queue.add(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status status = queue.poll();
            tail.next = status.node;
            tail = tail.next;
            if (status.node.next != null) {
                queue.add(new Status(status.node.next.val, status.node.next));
            }
        }
        return head.next;
    }

    public ListNode mergeKListsSolution2(ListNode[] lists) {
        int n;
        if (lists == null || (n = lists.length) == 0) {
            return null;
        }
        for (int i = 1; i < n; ++i) {
            lists[i] = mergeTwoLists(lists[i - 1], lists[i]);
        }
        return lists[n - 1];
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
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
