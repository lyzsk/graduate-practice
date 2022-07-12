package cn.sichu.graduate.practice.leetcode.utils;

import java.util.List;

/**
 * @author sichu
 * @date 2022/07/09
 */
public class Node4 {
    public int val;
    public List<Node4> children;

    public Node4() {

    }

    public Node4(int _val) {
        val = _val;
    }

    public Node4(int _val, List<Node4> _children) {
        val = _val;
        children = _children;
    }
}
