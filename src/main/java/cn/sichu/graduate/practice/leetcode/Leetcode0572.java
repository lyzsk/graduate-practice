package cn.sichu.graduate.practice.leetcode;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/05/27
 */
public class Leetcode0572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == null && subRoot == null;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null;
        }
        return node1.val == node2.val && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }
}
