package cn.sichu.graduate_practice.codetop;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * 频率33
 * <p>
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 * 
 * @author sichu
 * @date 2022/05/09
 */
public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(0, dfs(root.left));
        int rightSum = Math.max(0, dfs(root.right));
        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }
}
