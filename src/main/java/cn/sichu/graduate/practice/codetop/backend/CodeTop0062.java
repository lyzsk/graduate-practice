package cn.sichu.graduate.practice.codetop.backend;

import cn.sichu.graduate.practice.codetop.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class CodeTop0062 {
    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left += dfs(root.left) + 1;
        }
        if (root.right != null) {
            right += dfs(root.right) + 1;
        }
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}
