package cn.sichu.graduate.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 同余定理： presum[j] % k == presum[i] % k 等价于 (presum[j] - presum[i]) % k == 0
 * <p>
 * 又因为length > 2, 所以要判断 j - i >= 2; 否则的话continue, 防止更新 (余数, index) 的键值对
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Leetcode0523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int presum = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            int key = k == 0 ? presum : presum % k;
            if (map.containsKey(key)) {
                if (i - map.get(key) >= 2) {
                    return true;
                }
                continue;
            }
            map.put(key, i);
        }
        return false;
    }
}
