package cn.sichu.graduate_practice.easy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/smallest-range-i/
 * 
 * @author sichu
 * @date 2022/04/30
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int maxNum = Arrays.stream(nums).max().getAsInt();
        return maxNum - minNum <= 2 * k ? 0 : maxNum - minNum - 2 * k;
    }

    public int smallestRangeISolution2(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        return max - min <= 2 * k ? 0 : max - min - 2 * k;
    }
}
