package cn.sichu.graduate.practice.leetcode.leetcode75level1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * @author sichu
 * @date 2022/07/09
 */
public class Leetcode0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                level.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
