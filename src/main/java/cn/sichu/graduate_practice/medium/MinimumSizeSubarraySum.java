package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 
 * @author sichu
 * @date 2022/04/16
 */
public class MinimumSizeSubarraySum {
    /**
     * O(n)
     * <p>
     * O(1)
     * 
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                ++left;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
