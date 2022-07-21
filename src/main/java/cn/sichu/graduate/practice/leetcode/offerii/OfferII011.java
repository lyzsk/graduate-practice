package cn.sichu.graduate.practice.leetcode.offerii;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sichu
 * @date 2022/07/21
 */
public class OfferII011 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int presum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i] == 1 ? 1 : -1;
            int preIndex = map.getOrDefault(presum, i);
            if (preIndex == i) {
                map.put(presum, i);
            } else {
                res = Math.max(res, i - preIndex);
            }
        }
        return res;
    }
}
