package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 队列中保存的是该数值对应的数组下标位置
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * <p>
 * 输出: [3,3,5,5,6,7]
 * <p>
 * 初始状态：L=R=0,队列:{}
 * <p>
 * i=0,nums[0]=1。队列为空,直接加入。队列：{1}
 * <p>
 * i=1,nums[1]=3。队尾值为1，3>1，弹出队尾值，加入3。队列：{3}
 * <p>
 * i=2,nums[2]=-1。队尾值为3，-1<3，直接加入。队列：{3,-1}。此时窗口已经形成，L=0,R=2，result=[3]
 * <p>
 * i=3,nums[3]=-3。队尾值为-1，-3<-1，直接加入。队列：{3,-1,-3}。队首3对应的下标为1，L=1,R=3，有效。result=[3,3]
 * <p>
 * i=4,nums[4]=5。队尾值为-3，5>-3，依次弹出后加入。队列：{5}。此时L=2,R=4，有效。result=[3,3,5]
 * <p>
 * i=5,nums[5]=3。队尾值为5，3<5，直接加入。队列：{5,3}。此时L=3,R=5，有效。result=[3,3,5,5]
 * <p>
 * i=6,nums[6]=6。队尾值为3，6>3，依次弹出后加入。队列：{6}。此时L=4,R=6，有效。result=[3,3,5,5,6]
 * <p>
 * i=7,nums[7]=7。队尾值为6，7>6，弹出队尾值后加入。队列：{7}。此时L=5,R=7，有效。result=[3,3,5,5,6,7]
 * <p>
 * 本质上是维护一个 单调递减栈， 当滑动窗口已经形成的时候，不断的弹出First元素，既是最大值
 * 
 * @author sichu
 * @date 2022/05/25
 */
public class Leetcode0239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
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
