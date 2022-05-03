package cn.sichu.graduate_practice.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * 
 * @author sichu
 * @date 2022/05/03
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        if (root != null) {
            stack.addLast(root);
        }
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pollFirst();
                level.add(node.val);

                if (node.left != null) {
                    stack.addLast(node.left);
                }
                if (node.right != null) {
                    stack.addLast(node.right);
                }
            }
            res.add(0, level);
        }
        return res;
    }
}
