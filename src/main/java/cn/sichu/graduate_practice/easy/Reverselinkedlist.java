package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 
 * @author sichu
 * @date 2022/04/05
 */
public class Reverselinkedlist {
    public ListNode reverseList(ListNode head) {
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
}
