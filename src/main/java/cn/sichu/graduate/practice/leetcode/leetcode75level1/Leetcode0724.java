package cn.sichu.graduate.practice.leetcode.leetcode75level1;

/**
 * @author sichu
 * @date 2022/06/30
 */
public class Leetcode0724 {
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
