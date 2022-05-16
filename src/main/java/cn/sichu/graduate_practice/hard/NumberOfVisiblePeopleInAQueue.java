package cn.sichu.graduate_practice.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/number-of-visible-people-in-a-queue/
 * 
 * @author sichu
 * @date 2022/05/16
 */
public class NumberOfVisiblePeopleInAQueue {
    /**
     * O(n)
     * <p>
     * O(n)
     * 
     * @param heights
     * @return
     */
    public int[] canSeePersonsCount(int[] heights) {
        int[] res = new int[heights.length];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!deque.isEmpty()) {
                ++res[i];
                if (heights[i] <= heights[deque.peekFirst()]) {
                    break;
                }
                deque.removeFirst();
            }
            deque.addFirst(i);
        }
        return res;
    }
}
