package cn.sichu.graduate.practice.leetcode;

/**
 * dp[i] 表示到第 i 天结束时的最低消费
 * <p>
 * 如果第 i 天需要票： dp[i] = min(dp[i - 1] + costs[0], dp[i - 7] + costs[1], dp[i - 30] + costs[2])
 * <p>
 * 如果第 i 天不需要票： dp[i] = dp[i - 1];
 * 
 * @author sichu
 * @date 2022/06/08
 */
public class Leetcode0983 {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        dp[0] = 0;
        int idx = 0;
        for (int i = 1; i <= lastDay; i++) {
            if (i == days[idx]) {
                dp[i] = Math.min((i >= 1 ? dp[i - 1] : 0) + costs[0],
                    Math.min((i >= 7 ? dp[i - 7] : 0) + costs[1], (i >= 30 ? dp[i - 30] : 0) + costs[2]));
                ++idx;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[lastDay];
    }
}
