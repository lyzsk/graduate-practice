package cn.sichu.graduate_practice.medium;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-even-length-groups/
 * 
 * @author sichu
 * @date 2022/04/06
 */
public class ReverseNodesInEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = head;
        int flag = 0;

        for (int i = 1; flag == 0; i++) {
            int count = 0;
            ListNode leftNode = dummy;
            ListNode rightNode = null;

            while (pre != null && count < i) {
                rightNode = pre;
                dummy = dummy.next;
                pre = pre.next;
                ++count;

                if (pre == null) {
                    flag = 1;
                }
            }

            if (count % 2 == 0) {
                dummy = reverseList(leftNode, rightNode);
            }
        }
        return head;
    }

    private ListNode reverseList(ListNode left, ListNode right) {
        ListNode leftNode = left.next;

        ListNode tmp = leftNode;
        while (tmp != right) {
            ListNode cur = tmp;

            tmp = tmp.next;
            cur.next = right.next;
            right.next = cur;
        }

        left.next = right;
        return leftNode;
    }
}
