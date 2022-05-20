package cn.sichu.graduate_practice.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 频率55
 * <p>
 * https://leetcode.cn/problems/sliding-window-maximum/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[] {};
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] res = new int[nums.length - k + 1];
        // 一开始没形成窗口，left在左边界的左边，是负值
        for (int left = 1 - k, right = 0; right < nums.length; left++, right++) {
            // 删除 deque 中对应的 nums[left - 1]
            if (left > 0 && deque.peekFirst() == nums[left - 1]) {
                deque.removeFirst();
            }
            // 保持 deque 递减
            while (!deque.isEmpty() && deque.peekLast() < nums[right]) {
                deque.removeLast();
            }
            deque.addLast(nums[right]);
            // 记录滑动窗口最大值
            if (left >= 0) {
                res[left] = deque.peekFirst();
            }
        }
        return res;
    }
}
