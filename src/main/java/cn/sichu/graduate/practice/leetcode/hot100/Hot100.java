package cn.sichu.graduate.practice.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author sichu
 * @date 2022/06/09
 */
public class Hot100 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peekFirst()] < temperatures[i]) {
                int idx = stack.removeFirst();
                res[idx] = i - idx;
            }
            stack.addFirst(i);
        }
        return res;
    }
}
