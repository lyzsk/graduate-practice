package cn.sichu.graduate_practice.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 
 * @author sichu
 * @date 2022/04/27
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> stack = new ArrayDeque<Integer>();

        if (nums.length < 3) {
            return res;
        } else {
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == -nums[i]) {
                        stack.push(nums[right]);
                        stack.push(nums[left]);
                        stack.push(nums[i]);
                        res.add(new ArrayList<Integer>(stack));
                        ++left;
                        --right;
                        stack.clear();

                        while (left < right && nums[left] == nums[left - 1]) {
                            ++left;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            --right;
                        }

                    } else if (nums[left] + nums[right] < -nums[i]) {
                        ++left;
                    } else {
                        --right;
                    }
                }
            }
        }
        return res;
    }
}
