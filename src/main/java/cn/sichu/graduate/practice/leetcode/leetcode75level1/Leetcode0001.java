package cn.sichu.graduate.practice.leetcode.leetcode75level1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/07/14
 */
public class Leetcode0001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
