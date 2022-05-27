package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

public class Leetcode0173 {
    private TreeNode cur;
    private Deque<TreeNode> stack;

    public Leetcode0173(TreeNode root) {
        cur = root;
        stack = new ArrayDeque<TreeNode>();
    }

    public int next() {
        while (cur != null) {
            stack.addFirst(cur);
            cur = cur.left;
        }
        cur = stack.removeFirst();
        int res = cur.val;
        cur = cur.right;
        return res;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
