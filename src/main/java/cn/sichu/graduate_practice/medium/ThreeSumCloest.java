package cn.sichu.graduate_practice.medium;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * 
 * @author sichu
 * @date 2022/04/27
 */
public class ThreeSumCloest {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        if (nums.length < 3) {
            return res;
        } else {
            int threeDiff = Integer.MAX_VALUE;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                int twoSum = 0;
                int twoDiff = Integer.MAX_VALUE;

                while (left < right) {
                    if (Math.abs(nums[left] + nums[right] - (target - nums[i])) < twoDiff) {
                        twoSum = nums[left] + nums[right];
                        twoDiff = Math.abs(nums[left] + nums[right] - (target - nums[i]));
                    }
                    if (nums[left] + nums[right] < target - nums[i]) {
                        ++left;
                    } else {
                        --right;
                    }
                }

                if (Math.abs(nums[i] + twoSum - target) < threeDiff) {
                    threeDiff = Math.abs(nums[i] + twoSum - target);
                    res = nums[i] + twoSum;
                }
            }
        }
        return res;
    }
}
