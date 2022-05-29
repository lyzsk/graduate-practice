package cn.sichu.graduate.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 因为 presum - k 会出现负值， 没法把 Map 优化成 int[]
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Leetcode0560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int presum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            if (map.containsKey(presum - k)) {
                count += map.get(presum - k);
            }
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
