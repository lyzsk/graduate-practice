package cn.sichu.graduate.practice.leetcode.leetcode75level1;

import java.util.ArrayList;
import java.util.List;

import cn.sichu.graduate.practice.leetcode.utils.Node4;

public class Leetcode0589 {
    public List<Integer> preorder(Node4 root) {
        List<Integer> res = new ArrayList<Integer>();
        pre(root, res);
        return res;
    }

    private static void pre(Node4 root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node4 node : root.children) {
            pre(node, res);
        }
    }
}
