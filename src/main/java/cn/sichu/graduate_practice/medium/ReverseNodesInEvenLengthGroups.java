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
        ListNode prehead = new ListNode();
        prehead.next = head;
        ListNode cur = head;
        int flag = 0;

        for (int i = 1; flag == 0; i++) {
            int count = 0;
            ListNode reversePre = prehead;
            ListNode reverseRight = prehead;

            while (cur != null && count < i) {
                reverseRight = reverseRight.next;
                cur = cur.next;
                prehead = prehead.next;
                ++count;

                if (cur == null) {
                    flag = 1;
                }
            }

            if (count % 2 == 0) {
                prehead = reverse(reversePre, reverseRight);
            }
        }

        return head;
    }

    private ListNode reverse(ListNode prehead, ListNode rightNode) {
        ListNode leftNode = prehead.next;

        ListNode tmp = leftNode;
        while (tmp != rightNode) {
            ListNode cur = tmp;
            tmp = tmp.next;
            cur.next = rightNode.next;
            rightNode.next = cur;
        }
        prehead.next = rightNode;
        return leftNode;
    }
}
