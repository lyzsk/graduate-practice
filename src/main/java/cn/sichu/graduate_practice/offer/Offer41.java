package cn.sichu.graduate_practice.offer;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class Offer41 {
    /** initialize your data structure here. */

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public Offer41() {
        minHeap = new PriorityQueue<Integer>((o1, o2) -> (o2 - o1));
        maxHeap = new PriorityQueue<Integer>((o1, o2) -> (o1 - o2));
    }

    public void addNum(int num) {
        if (minHeap.isEmpty() || num <= minHeap.peek()) {
            minHeap.add(num);
            if (maxHeap.size() + 1 < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        } else {
            maxHeap.add(num);
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
