package cn.sichu.graduate_practice.offerii;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/tvdfij/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class OfferII012 {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
