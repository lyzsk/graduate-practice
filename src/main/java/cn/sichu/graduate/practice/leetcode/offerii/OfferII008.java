package cn.sichu.graduate.practice.leetcode.offerii;

/**
 * @author sichu
 * @date 2022/07/20
 */
public class OfferII008 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                ++left;
            }
            ++right;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
