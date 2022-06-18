package cn.sichu.graduate.practice.leetcode.offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/06/18
 */
public class Offer49 {
    public int nthUglyNumber(int n) {
        int[] factors = new int[] {2, 3, 5};
        Set<Long> used = new HashSet<Long>();
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        used.add(1L);
        minHeap.add(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long cur = minHeap.poll();
            ugly = (int)cur;
            for (int factor : factors) {
                long next = cur * factor;
                if (used.add(next)) {
                    minHeap.add(next);
                }
            }
        }
        return ugly;
    }
}
