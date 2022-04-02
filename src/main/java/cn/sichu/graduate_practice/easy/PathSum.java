package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * 
 * @author sichu
 * @date 2022/04/02
 */
public class PathSum {
    /**
     * O(n)
     * <p>
     * O(h)
     * 
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
