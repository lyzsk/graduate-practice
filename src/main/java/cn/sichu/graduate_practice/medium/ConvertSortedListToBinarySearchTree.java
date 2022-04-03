package cn.sichu.graduate_practice.medium;

import cn.sichu.graduate_practice.easy.ListNode;
import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * 
 * @author sichu
 * @date 2022/04/03
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return helper(head);
    }

    private TreeNode helper(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pre = null;

        // 快指针为null时 慢指针肯定走到中点了
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            if (fast.next == null) {
                fast = fast.next;
            } else {
                fast = fast.next.next;
            }
        }

        TreeNode root = new TreeNode(slow.val);
        ListNode next = slow.next;

        if (pre != null) {
            pre.next = null;
        }
        if (next != null) {
            slow.next = null;
        }

        root.left = helper(head);
        root.right = helper(next);
        return root;
    }
}
