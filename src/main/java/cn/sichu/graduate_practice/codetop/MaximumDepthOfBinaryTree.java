package cn.sichu.graduate_practice.codetop;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * 频率59
 * <p>
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
