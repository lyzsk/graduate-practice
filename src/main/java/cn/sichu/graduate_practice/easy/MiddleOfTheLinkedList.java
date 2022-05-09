package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 * 
 * @author sichu
 * @date 2022/05/08
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode res = slow;
        return res;
    }
}
