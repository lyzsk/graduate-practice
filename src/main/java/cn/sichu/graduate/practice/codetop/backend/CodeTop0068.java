package cn.sichu.graduate.practice.codetop.backend;

import java.util.Arrays;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class CodeTop0068 {
    /**
     * 自底向上动态规划
     * <p>
     * memo[n]: 表示凑成总金额为 n 所需的最少硬币个数
     * <p>
     * amount + 1 是不可能达到的换取数量，用其进行填充
     * <p>
     * memo[i] 有两种实现方式：
     * <ul>
     * <li>一是包含当前的 coints[i], 那么剩余钱就是 i - coins[i], 这种操作需要兑换的硬币数是 memo[i - coins[j]] + 1</li>
     * <li>另一种就是不包含，要兑换的硬币数是 memo[i]</li>
     * </ul>
     * 
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
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
