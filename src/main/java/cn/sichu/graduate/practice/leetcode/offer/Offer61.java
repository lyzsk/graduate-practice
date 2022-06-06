package cn.sichu.graduate.practice.leetcode.offer;

import java.util.Arrays;

/**
 * 
 * @author sichu
 * @date 2022/06/05
 */
public class Offer61 {
    // public boolean isStraight(int[] nums) {
    // Set<Integer> set = new HashSet<Integer>();
    // int max = 0;
    // int min = 14;
    // for (int i = 0; i < nums.length; i++) {
    // if (nums[i] == 0) {
    // continue;
    // }
    // max = Math.max(max, nums[i]);
    // min = Math.min(min, nums[i]);
    // if (set.contains(nums[i])) {
    // return false;
    // }
    // set.add(nums[i]);
    // }
    // return max - min < 5;
    // }
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                ++joker;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[nums.length - 1] - nums[joker] < 5;
    }
}
