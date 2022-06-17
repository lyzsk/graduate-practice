package cn.sichu.graduate.practice.leetcode;

import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/06/15
 */
public class Leetcode0532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for (int left = 0; left < nums.length; left++) {
            if (left - 1 >= 0 && nums[left] == nums[left - 1]) {
                continue;
            }
            for (int right = left + 1; right < nums.length; right++) {
                int diff = nums[right] - nums[left];
                if (diff == k) {
                    ++res;
                    break;
                } else if (diff > k) {
                    break;
                }
            }
        }
        return res;
    }
}
