package cn.sichu.graduate.practice.leetcode;

import java.util.PriorityQueue;

/**
 * 关键点在于，大小根堆的labmda表达式里，一定要用 Integer.compare()，否则会int溢出
 * <p>
 * minHeap 要比 maxHeap 多，因此，删除和添加都与 minHeap比较，因为 maxHeap可能为空，
 * <p>
 * 即： 如果是奇数窗口，让minHeap比 maxHeap 多一个
 * 
 * @author sichu
 * @date 2022/06/03
 */
public class Leetcode0480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int count = n - k + 1;
        double[] res = new double[count];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> Integer.compare(o2, o1));
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1, o2) -> Integer.compare(o1, o2));
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = 0; i < (k >> 1); i++) {
            maxHeap.add(minHeap.poll());
        }
        res[0] = getMid(maxHeap, minHeap);
        for (int i = k; i < n; i++) {
            int add = nums[i];
            int delete = nums[i - k];
            if (add >= minHeap.peek()) {
                minHeap.add(add);
            } else {
                maxHeap.add(add);
            }
            if (delete >= minHeap.peek()) {
                minHeap.remove(delete);
            } else {
                maxHeap.remove(delete);
            }
            adjust(maxHeap, minHeap);
            res[i - k + 1] = getMid(maxHeap, minHeap);
        }
        return res;
    }

    private static void adjust(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        while (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        while (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private static double getMid(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() / 2.0) + (minHeap.peek() / 2.0);
        } else {
            return minHeap.peek() * 1.0;
        }
    }
}
