package cn.sichu.graduate.practice.leetcode.offerii;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author sichu
 * @date 2022/07/16
 */
public class OfferII041 {
    private Queue<Integer> queue;
    private int size;
    private double sum;

    /** Initialize your data structure here. */
    public OfferII041(int size) {
        this.queue = new ArrayDeque<Integer>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.add(val);
        sum += val;
        return sum / queue.size();
    }
}
