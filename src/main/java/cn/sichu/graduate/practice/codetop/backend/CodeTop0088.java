package cn.sichu.graduate.practice.codetop.backend;

import cn.sichu.graduate.practice.codetop.utils.ListNode;

/**
 * 给定一个奇数位升序，偶数位降序的链表，将其重新排序。
 * <p>
 * 输入: 1->8->3->6->5->4->7->2->NULL
 * <p>
 * 输出: 1->2->3->4->5->6->7->8->NULL
 * <p>
 * 分析：
 * <ol>
 * <li>按奇偶位置拆分链表，得1->3->5->7->NULL 和 8->6->4->2->NULL</li>
 * <li>反转偶链表，得1->3->5->7->NULL 和 2->4->6->8->NULL</li>
 * <li>合并两个有序链表，得1->2->3->4->5->6->7->8->NULL</li>
 * </ol>
 * 
 * @see https://mp.weixin.qq.com/s/0WVa2wIAeG0nYnVndZiEXQ
 * @author sichu
 * @date 2022/05/24
 */
public class CodeTop0088 {
    public ListNode sortLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddCur = head;
        ListNode evenCur = oddCur.next;
        ListNode oddHead = oddCur;
        ListNode evenHead = evenCur;
        while (evenCur != null) {
            oddCur.next = evenCur.next;
            if (oddCur.next != null) {
                evenCur.next = oddCur.next.next;
            }
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        evenHead = reverseList(evenHead);
        return mergeList(oddHead, evenHead);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null) {
            ListNode tmp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = tmp;
        }
        return slow;
    }

    private static ListNode mergeList(ListNode l1, ListNode l2) {
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
