package cn.sichu.graduate.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sichu
 * @date 2022/05/25
 */
public class Leetcode0347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        Arrays.stream(nums).forEach(num -> freq.put(num, freq.getOrDefault(num, 0) + 1));
        return freq.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).limit(k)
            .mapToInt(Map.Entry::getKey).toArray();
    }
}
