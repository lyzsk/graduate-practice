package cn.sichu.graduate.practice.codetop.backend;

import cn.sichu.graduate.practice.codetop.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class CodeTop0069 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1 || left == -1 || right == -1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
