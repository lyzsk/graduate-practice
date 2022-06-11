package cn.sichu.graduate.practice.leetcode.tencent50;

/**
 * 
 * @author sichu
 * @date 2022/06/11
 */
public class Tencent18 {
    public int maxSubArray(int[] nums) {
        int dp = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            res = Math.max(dp, res);
        }
        return res;
    }
}
