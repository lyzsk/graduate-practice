package cn.sichu.graduate.practice.leetcode;

/**
 * 背包问题，rows:物品索引(nums[i]), cols:背包容量包含0(taget + 1)
 * <p>
 * sum 为奇数， max 大于 taget 的一半，直接返回false
 * <p>
 * 采用倒序操作，因为是从后往前更新，j-nums[i] < j意味着用 dp[j-nums[i]] 来更新 dp[j] 时，dp[j-nums[i]]仍代表着上一行的值，于是就不会出错。
 * <ul>
 * 可p以优化成一维dp:
 * <li>dp[0] = true; -> dp[i][0] = true;</li>
 * <li>dp[nums[0]] = true; -> dp[0][nums[0] = true; 不会越界</li>
 * </ul>
 * 0-1背包： Leetcode0416, Leetcode0474, Leetcode0494, Leetcode0879, Leetcode1049
 * <p>
 * 完全背包： Leetcode0322, Leetcode0518, Leetcode1449, Leetcode0279
 * 
 * @author sichu
 * @date 2022/06/05
 */
public class Leetcode0416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            if (num > max) {
                max = num;
            }
        }
        if ((sum & 1) == 1 || max > sum >> 1) {
            return false;
        }
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= 0 && nums[i] <= j; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
            if (dp[target]) {
                return true;
            }
        }
        return dp[target];
    }
    // public boolean canPartition(int[] nums) {
    // int sum = Arrays.stream(nums).sum();
    // if ((sum & 1) == 1) {
    // return false;
    // }
    // int target = sum >> 1;
    // boolean[][] dp = new boolean[nums.length][target + 1];
    // if (nums[0] <= target) {
    // dp[0][nums[0]] = true;
    // }
    // for (int i = 1; i < nums.length; i++) {
    // for (int j = 0; j <= target; j++) {
    // dp[i][j] = dp[i - 1][j];
    // if (nums[i] == j) {
    // dp[i][j] = true;
    // continue;
    // }
    // if (nums[i] < j) {
    // dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
    // }
    // }
    // }
    // return dp[nums.length - 1][target];
    // }
}
