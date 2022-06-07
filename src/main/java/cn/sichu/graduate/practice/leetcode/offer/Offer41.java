package cn.sichu.graduate.practice.leetcode.offer;

import java.util.PriorityQueue;

/**
 * 
 * @author sichu
 * @date 2022/06/06
 */
public class Offer41 {
    /** initialize your data structure here. */

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public Offer41() {
        minHeap = new PriorityQueue<Integer>((o1, o2) -> (o1 - o2));
        maxHeap = new PriorityQueue<Integer>((o1, o2) -> (o2 - o1));
    }

    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
