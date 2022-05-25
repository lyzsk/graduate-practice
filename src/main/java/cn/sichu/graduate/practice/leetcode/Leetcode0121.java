package cn.sichu.graduate.practice.leetcode;

/**
 * 
 * @author sichu
 * @date 2022/05/25
 */
public class Leetcode0121 {
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
