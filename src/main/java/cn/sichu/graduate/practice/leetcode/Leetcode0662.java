package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/05/30
 */
public class Leetcode0662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.addLast(root);
        int res = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            res = Math.max(res, deque.peekLast().val - deque.peekFirst().val + 1);
            while (size > 0) {
                TreeNode node = deque.pollFirst();
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    deque.addLast(node.right);
                }
                --size;
            }
        }
        return res;
    }
}
