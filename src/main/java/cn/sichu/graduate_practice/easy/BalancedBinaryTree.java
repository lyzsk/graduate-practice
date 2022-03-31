package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/solution/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class BalancedBinaryTree {
    /**
     * O(n)
     * <p>
     * O(n)
     * 
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1 || leftHeight == -1 || rightHeight == -1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }
}
