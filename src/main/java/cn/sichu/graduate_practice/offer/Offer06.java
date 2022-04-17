package cn.sichu.graduate_practice.offer;

import java.util.ArrayDeque;
import java.util.Deque;

import cn.sichu.graduate_practice.easy.ListNode;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 
 * @author sichu
 * @date 2022/04/17
 */
public class Offer06 {
    /**
     * O(n)
     * <p>
     * O(n)
     * 
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public int[] reversePrintSolution2(ListNode head) {
        if (head == null) {
            return new int[] {};
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            ++len;
            cur = cur.next;
        }

        int[] res = new int[len];
        cur = head;
        while (cur != null) {
            res[--len] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}
