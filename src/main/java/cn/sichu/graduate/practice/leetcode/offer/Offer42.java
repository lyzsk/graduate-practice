package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        int dp = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dp = Math.max(nums[i] + dp, nums[i]);
            res = Math.max(res, dp);
        }
        return res;
    }
}
