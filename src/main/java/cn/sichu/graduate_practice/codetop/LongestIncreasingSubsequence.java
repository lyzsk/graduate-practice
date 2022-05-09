package cn.sichu.graduate_practice.codetop;

import java.util.Arrays;

/**
 * 频率28
 * <p>
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 
 * @author sichu
 * @date 2022/05/08
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;

        if (nums.length < 2) {
            return len;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
