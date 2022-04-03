package cn.sichu.graduate_practice.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * @author sichu
 * @date 2022/04/03
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        if (root != null) {
            q.add(root);
        }

        while (!q.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<Integer>();

            int size = q.size();
            for (int i = size; i > 0; i--) {
                TreeNode node = q.poll();

                if (res.size() % 2 == 0) {
                    tmp.addLast(node.val);
                } else {
                    tmp.addFirst(node.val);
                }

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            res.add(tmp);
        }

        return res;
    }
}
