package cn.sichu.graduate_practice.lcp;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-ran-se-UGC/
 * 
 * @author sichu
 * @date 2022/05/03
 */
public class LCP34 {
    public int maxValue(TreeNode root, int k) {
        int[] dp = dfs(root, k);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < k + 1; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private static int[] dfs(TreeNode root, int k) {
        int[] dp = new int[k + 1];

        // 1. 初始化： 空节点为底， 自底向上
        if (root == null) {
            return dp;
        }
        // 2. 获取左右子树染色状态的dp表
        int[] left = dfs(root.left, k);
        int[] right = dfs(root.right, k);
        // 3. 更新处理 root 染色/不染色 的情况下的dp表
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        for (int i = 0; i < k + 1; i++) {
            maxLeft = Math.max(maxLeft, left[i]);
            maxRight = Math.max(maxRight, right[i]);
        }
        dp[0] = maxLeft + maxRight;

        // 染色root
        for (int i = 1; i < k + 1; i++) {
            for (int j = 0; j < i; j++) {
                // 还需要染色 i - 1 个节点， 左子树 j 个， 右子树 i - 1 - j 个
                dp[i] = Math.max(dp[i], root.val + left[j] + right[i - 1 - j]);
            }
        }
        return dp;
    }
}
