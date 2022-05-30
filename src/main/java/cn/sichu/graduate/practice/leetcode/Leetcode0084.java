package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Leetcode0084 {
    /**
     * 可以加入哨兵进行优化，省去 empty判断 和 遍历结束后判断栈内元素的过程，
     * <p>
     * int[]头尾加入0，stack 初始化的时候把这个0加入栈中， 避免判断 stack.isEmpty() 的情况， 并省略第二段重复的逻辑代码
     * <p>
     * 重点是：
     * <ul>
     * <li>newHeights拷贝: newHeights[i + 1] = heights[i];</li>
     * <li>初始化栈: stack.addFirst(0);</li>
     * <li>入栈操作的遍历，从 i = 1 开始</li>
     * </ul>
     * 
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.addFirst(0);
        int[] newHeights = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;
        for (int i = 1; i < heights.length; i++) {
            while (heights[i] < heights[stack.peekFirst()]) {
                int height = heights[stack.removeFirst()];
                while (heights[stack.peekFirst()] == height) {
                    stack.removeFirst();
                }
                int width;
                width = i - stack.peekFirst() - 1;
                res = Math.max(res, height * width);
            }
            stack.addFirst(i);
        }
        return res;
    }
    // public int largestRectangleArea(int[] heights) {
    // int res = 0;
    // Deque<Integer> stack = new ArrayDeque<Integer>();
    // for (int i = 0; i < heights.length; i++) {
    // while (!stack.isEmpty() && heights[i] < heights[stack.peekFirst()]) {
    // int curHeight = heights[stack.removeFirst()];
    // while (!stack.isEmpty() && heights[stack.peekFirst()] == curHeight) {
    // stack.removeFirst();
    // }
    // int curWidth;
    // if (stack.isEmpty()) {
    // curWidth = i;
    // } else {
    // curWidth = i - stack.peekFirst() - 1;
    // }
    // res = Math.max(res, curHeight * curWidth);
    // }
    // stack.addFirst(i);
    // }
    // while (!stack.isEmpty()) {
    // int curHeight = heights[stack.removeFirst()];
    // while (!stack.isEmpty() && heights[stack.peekFirst()] == curHeight) {
    // stack.removeFirst();
    // }
    // int curWidth;
    // if (stack.isEmpty()) {
    // curWidth = heights.length;
    // } else {
    // curWidth = heights.length - stack.peekFirst() - 1;
    // }
    // res = Math.max(res, curHeight * curWidth);
    // }
    // return res;
    // }
}
