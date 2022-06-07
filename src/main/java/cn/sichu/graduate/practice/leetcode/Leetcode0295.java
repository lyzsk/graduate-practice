package cn.sichu.graduate.practice.leetcode;

import java.util.PriorityQueue;

/**
 * 小顶堆在上，大顶堆在下的对冲模型，
 * <p>
 * 加入元素时，
 * <ol>
 * <li>如果当前所有元素个数为偶数，先加入小顶堆，再根据小顶堆的poll加入大顶堆</li>
 * <li>如果当前所有元素个数为奇数，先加入大顶堆，再根据大顶堆的poll加入小顶堆</li>
 * </ol>
 * 这样大顶堆的元素最多比小顶堆的元素 多一个
 * 
 * @author sichu
 * @date 2022/06/06
 */
public class Leetcode0295 {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public Leetcode0295() {
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
