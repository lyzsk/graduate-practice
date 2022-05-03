package cn.sichu.graduate_practice.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>
 * similar offer: {@link cn.sichu.graduate_practice.offer.Offer32I}
 * <p>
 * same offer: {@link cn.sichu.graduate_practice.offer.Offer32II}
 * 
 * @author sichu
 * @date 2022/05/03
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

        queue.addLast(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                level.add(node.val);

                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
