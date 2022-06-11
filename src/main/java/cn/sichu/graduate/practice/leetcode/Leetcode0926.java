package cn.sichu.graduate.practice.leetcode;

/**
 * 动态规划,
 * <ol>
 * <li>dp[i][0], 当前位为0时，需要改变的最少字符个数</li>
 * <li>dp[i][1], 当前位为1时，需要改变的最少字符个数</li>
 * </ol>
 * dp[i][0] = dp[i - 1][0] + (arr[i] == '0' ? 0 : 1); -> 当前位为0， 则上一位肯定只能为0，满足最少
 * <p>
 * 优化： dp0 代表以0为结尾的字符串需要的最小翻转次数， dp1 代表以1为结尾的字符串需要的最小翻转次数
 * <ul>
 * <li>要点： 因为要用到上一轮的 dp0, 需要先更新dp1</li>
 * </ul>
 * 
 * @author sichu
 * @date 2022/06/10
 */
public class Leetcode0926 {
    // public int minFlipsMonoIncr(String s) {
    // int n = s.length();
    // int[][] dp = new int[n][2];
    // char[] arr = s.toCharArray();
    // dp[0][0] = arr[0] == '0' ? 0 : 1;
    // dp[0][1] = arr[0] == '1' ? 0 : 1;
    // for (int i = 1; i < n; i++) {
    // dp[i][0] = dp[i - 1][0] + (arr[i] == '0' ? 0 : 1);
    // dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (arr[i] == '1' ? 0 : 1);
    // }
    // return Math.min(dp[n - 1][0], dp[n - 1][1]);
    // }
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int dp0 = arr[0] == '0' ? 0 : 1;
        int dp1 = arr[0] == '1' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            dp1 = Math.min(dp0, dp1) + (arr[i] == '1' ? 0 : 1);
            dp0 = dp0 + (arr[i] == '0' ? 0 : 1);
        }
        return Math.min(dp0, dp1);
    }
}
