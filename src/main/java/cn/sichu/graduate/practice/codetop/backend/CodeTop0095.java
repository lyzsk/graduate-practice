package cn.sichu.graduate.practice.codetop.backend;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class CodeTop0095 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]) {
                int idx = stack.removeFirst();
                res[idx] = i - idx;
            }
            stack.addFirst(i);
        }
        return res;
    }
}
