package cn.sichu.graduate.practice.leetcode;

/**
 * 动态规划做法，相似于最长公共子序列： Leetcode1143,
 * <p>
 * 区别在于这题是连续的子数组，只要看corner就可以了，否则为0
 * 
 * @author sichu
 * @date 2022/06/05
 */
public class Leetcode0718 {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m][n];
        dp[0][0] = nums1[0] == nums2[0] ? 1 : 0;
        int res = nums1[0] == nums2[0] ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = nums1[i] == nums2[0] ? 1 : 0;
            res = Math.max(res, dp[i][0]);
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = nums2[i] == nums1[0] ? 1 : 0;
            res = Math.max(res, dp[0][i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i - 1][j - 1] + 1 : 0;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
