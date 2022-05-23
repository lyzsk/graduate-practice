package cn.sichu.graduate.practice.codetop.backend;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author sichu
 * @date 2022/05/22
 */
public class CodeTop0056 {
    /**
     * 一开始没形成窗口，left在左边界的左边, left + k - 1 = 0 -> left = 1 - k; 当 left > 0 时，删除 deque 中对应的 nums[left - 1], 并且保持 deque 递减;
     * 当 left >= 0 时， 即窗口已经形成，记录滑动窗口的最大值
     * 
     * @param nums
     * @param k
     * @return res
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[] {};
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] res = new int[nums.length - k + 1];
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
