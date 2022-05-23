package cn.sichu.graduate.practice.leetcode.utils;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
