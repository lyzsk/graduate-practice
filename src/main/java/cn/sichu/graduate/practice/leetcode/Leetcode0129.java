package cn.sichu.graduate.practice.leetcode;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/06/03
 */
public class Leetcode0129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int pathSum) {
        if (root == null) {
            return 0;
        }
        int sum = pathSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
