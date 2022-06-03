package cn.sichu.graduate.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sichu
 * @date 2022/06/02
 */
public class Leetcode0594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for (int key : count.keySet()) {
            if (count.containsKey(key + 1)) {
                res = Math.max(res, count.get(key) + count.get(key + 1));
            }
        }
        return res;
    }
}
