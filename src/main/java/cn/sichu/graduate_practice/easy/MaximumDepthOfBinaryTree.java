package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class MaximumDepthOfBinaryTree {
    /**
     * O(n)
     * <p>
     * O(height)
     * 
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
