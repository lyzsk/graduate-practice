package cn.sichu.graduate_practice.codetop;

/**
 * 频率8
 * <p>
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 
 * @author sichu
 * @date 2022/05/05
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int dp = 0;
        int res = nums[0];

        for (int i = 0; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            res = Math.max(res, dp);
        }
        return res;
    }
}
