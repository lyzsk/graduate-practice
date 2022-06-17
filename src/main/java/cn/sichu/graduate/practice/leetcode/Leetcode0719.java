package cn.sichu.graduate.practice.leetcode;

import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/06/14
 */
public class Leetcode0719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int i = 0, j = 0; j < nums.length; j++) {
                while (nums[j] - nums[i] > mid) {
                    ++i;
                }
                count += j - i;
            }
            if (count >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
