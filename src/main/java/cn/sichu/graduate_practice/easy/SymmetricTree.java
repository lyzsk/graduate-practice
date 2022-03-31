package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class SymmetricTree {
    /**
     * O(n)
     * <p>
     * O(n)
     * 
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
