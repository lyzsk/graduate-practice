package cn.sichu.graduate_practice.offerii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/g5c51o/
 * <p>
 * same: {@link cn.sichu.graduate_practice.medium.TopKFrequentElements}
 * 
 * @author sichu
 * @date 2022/05/02
 */
public class OfferII060 {
    /**
     * O(nlogk)
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1, o2) -> freq.get(o1) - freq.get(o2));

        for (Integer key : freq.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    /**
     * O(n)
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequentSolution2(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        Arrays.stream(nums).forEach(num -> freq.put(num, freq.getOrDefault(num, 0) + 1));
        int[] res = freq.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).limit(k)
            .mapToInt(Map.Entry::getKey).toArray();
        return res;
    }
}
