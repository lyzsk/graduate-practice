package cn.sichu.graduate_practice.codetop;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * 频率57
 * <p>
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
