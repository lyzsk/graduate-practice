package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class MinimumDepthOfBinaryTree {
    /**
     * O(n)
     * <p>
     * O(Height)
     * 
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(min, minDepth(root.left));
        }
        if (root.right != null) {
            min = Math.min(min, minDepth(root.right));
        }
        return min + 1;
    }
}
