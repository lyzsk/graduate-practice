package cn.sichu.graduate.practice.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2022/06/17
 */
public class Offer59I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int left = 1 - k, right = 0; right < nums.length; left++, right++) {
            if (left > 0 && deque.peekFirst() == nums[left - 1]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[right]) {
                deque.removeLast();
            }
            deque.addLast(nums[right]);
            if (left >= 0) {
                res[left] = deque.peekFirst();
            }
        }
        return res;
    }
}
