package cn.sichu.graduate.practice.codetop.backend;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class CodeTop0074 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }
}
