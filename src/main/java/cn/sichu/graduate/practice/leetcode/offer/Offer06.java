package cn.sichu.graduate.practice.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

import cn.sichu.graduate.practice.leetcode.utils.ListNode;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode p = head;
        while (p != null) {
            stack.addFirst(p);
            p = p.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.removeFirst().val;
        }
        return res;
    }
}
