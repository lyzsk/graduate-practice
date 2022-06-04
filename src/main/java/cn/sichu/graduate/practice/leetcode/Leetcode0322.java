package cn.sichu.graduate.practice.leetcode;

import java.util.Arrays;

/**
 * 回溯是自顶向上的，这道题有很多 重复的计算 (取相同值的硬币)，应该用记忆化搜索dp，自底向上
 * <p>
 * int[] memo = new int[amount + 1]; 是因为，有一个0需要考虑，而且循环边界是 <= amount
 * <p>
 * memo[n]: 表示凑成总金额为 n 所需的最少硬币个数
 * <p>
 * 注意Arrays.fill(memo, amount + 1);，别 fill 了 Integer.MAX_VALUE,因为测试用例 conins = [2], amount = 3 这种的通过不了
 * 
 * @author sichu
 * @date 2022/06/04
 */
public class Leetcode0322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
                }
            }
        }
        return memo[amount] == (amount + 1) ? -1 : memo[amount];
    }
}
