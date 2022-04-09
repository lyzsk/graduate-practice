package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * 
 * @author sichu
 * @date 2022/04/08
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        int sum = 0;
        if (root.left != null) {
            if (isLeftNode(root.left)) {
                sum += root.left.val;
            } else {
                sum += dfs(root.left);
            }
        }
        if (root.right != null) {
            sum += dfs(root.right);
        }
        return sum;
    }

    private boolean isLeftNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
