package cn.sichu.graduate.practice.leetcode;

/**
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Leetcode0724 {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int presum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (presum == total - nums[i] - presum) {
                return i;
            }
            presum += nums[i];
        }
        return -1;
    }
}
