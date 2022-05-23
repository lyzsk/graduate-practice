package cn.sichu.graduate.practice.leetcode.offerii;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sichu
 * @date 2022/05/22
 */
public class OfferII004 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] res = freq.entrySet().stream().sorted((o1, o2) -> o1.getValue() - o2.getValue()).limit(1)
            .mapToInt(Map.Entry::getKey).toArray();
        return res[0];
    }
}
