package cn.sichu.graduate_practice.hard;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 
 * @author sichu
 * @date 2022/04/02
 */
public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    /**
     * O(n)
     * <p>
     * O(n)
     * 
     * @param root
     * @return
     */
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
