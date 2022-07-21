package cn.sichu.graduate.practice.leetcode.offerii;

/**
 * @author sichu
 * @date 2022/07/21
 */
public class OfferII012 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int presum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (presum == sum - nums[i] - presum) {
                return i;
            }
            presum += nums[i];
        }
        return -1;
    }
}
