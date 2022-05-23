package cn.sichu.graduate.practice.codetop.backend;

import cn.sichu.graduate.practice.codetop.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class CodeTop0065 {
    private int res = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int pathSum) {
        if (root == null) {
            return;
        }
        pathSum = pathSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += pathSum;
        }
        dfs(root.left, pathSum);
        dfs(root.right, pathSum);
    }
}
