package cn.sichu.graduate_practice.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>
 * Offer link: {@link cn.sichu.graduate_practice.offerii.OfferII027}
 * 
 * @author sichu
 * @date 2022/04/30
 */
public class PalindromeLinkedList {

    /**
     * O(n)
     * <p>
     * O(1)
     * 
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分尾节点，反转后半部分
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean res = true;
        while (res && p2 != null) {
            if (p1.val != p2.val) {
                res = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原
        firstHalfEnd.next = reverseList(secondHalfStart);
        return res;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 比方法1垃圾
     * <p>
     * O(n)
     * <p>
     * O(n)
     * 
     * @param head
     * @return
     */
    public boolean isPalindromeSolution2(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将linkedlist的值复制到数组中
        ListNode cur = head;
        while (cur != null) {
            vals.add(cur.val);
            cur = cur.next;
        }

        int left = 0;
        int right = vals.size() - 1;
        while (left < right) {
            if (!vals.get(left).equals(vals.get(right))) {
                return false;
            }
            // boxtype Integer不推荐用 ==
            // if (vals.get(left) != vals.get(right)) {
            // return false;
            // }
            ++left;
            --right;
        }
        return true;
    }

    /**
     * 本质和方法1一样，区别在于不还原反转后的后半部分，节省了O（n/2）
     * 
     * @param head
     * @return
     */
    public boolean isPalindromeSolution3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow.next;
        slow.next = null;
        ListNode pre = null;
        // 反转后半部分
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        // 比较 反转后的后半部分 和 前半部分，不还原反转后的链表
        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}
