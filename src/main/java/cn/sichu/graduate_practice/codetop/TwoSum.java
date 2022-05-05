package cn.sichu.graduate_practice.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * 频率9
 * <p>
 * https://leetcode-cn.com/problems/two-sum/
 * 
 * @author sichu
 * @date 2022/05/05
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
