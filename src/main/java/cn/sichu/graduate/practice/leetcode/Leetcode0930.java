package cn.sichu.graduate.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Leetcode0930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int presum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            if (map.containsKey(presum - goal)) {
                count += map.get(presum - goal);
            }
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
