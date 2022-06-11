package cn.sichu.graduate.practice.leetcode.tencent50;

import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/06/11
 */
public class Tencent10 {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        if (nums.length < 3) {
            return res;
        } else {
            Arrays.sort(nums);
            res = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(target - sum) < Math.abs(target - res)) {
                        res = sum;
                    }
                    if (sum > target) {
                        --right;
                    } else if (sum < target) {
                        ++left;
                    } else {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
