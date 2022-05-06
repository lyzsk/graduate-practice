package cn.sichu.graduate_practice.codetop;

/**
 * 频率12
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * @author sichu
 * @date 2022/05/05
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }
}
