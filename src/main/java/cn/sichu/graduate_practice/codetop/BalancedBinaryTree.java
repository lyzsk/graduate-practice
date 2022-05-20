package cn.sichu.graduate_practice.codetop;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * 频率58
 * <p>
 * https://leetcode.cn/problems/balanced-binary-tree/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1 || leftHeight == -1 || rightHeight == -1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
