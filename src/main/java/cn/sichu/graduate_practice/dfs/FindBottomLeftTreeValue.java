package cn.sichu.graduate_practice.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 * 
 * @author sichu
 * @date 2022/05/14
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.addLast(root);
        // int depth = 0;
        int res = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (i == 0) {
                    res = node.val;
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            // ++depth;
        }
        return res;
    }
}
