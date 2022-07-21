package cn.sichu.graduate.practice.leetcode.offerii;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/07/21
 */
public class OfferII010 {
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
