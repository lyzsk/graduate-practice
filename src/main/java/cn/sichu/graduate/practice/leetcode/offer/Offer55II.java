package cn.sichu.graduate.practice.leetcode.offer;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/06/07
 */
public class Offer55II {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) >= 0;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1 || left == -1 || right == -1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
