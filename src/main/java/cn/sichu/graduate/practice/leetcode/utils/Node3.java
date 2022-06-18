package cn.sichu.graduate.practice.leetcode.utils;

/**
 * @author sichu
 * @date 2022/06/18
 */
public class Node3 {
    public int val;
    public Node3 next;

    public Node3() {}

    public Node3(int _val) {
        val = _val;
    }

    public Node3(int _val, Node3 _next) {
        val = _val;
        next = _next;
    }
}
