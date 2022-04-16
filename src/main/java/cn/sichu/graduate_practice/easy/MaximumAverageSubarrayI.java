package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * 
 * @author sichu
 * @date 2022/04/16
 */
public class MaximumAverageSubarrayI {
    /**
     * O(n)
     * <p>
     * O(1)
     * 
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int left = 0, right = k; right < nums.length; right++) {
            sum = sum - nums[left] + nums[right];
            ++left;
            maxSum = Math.max(maxSum, sum);
        }
        return (double)maxSum / k;
    }
}
