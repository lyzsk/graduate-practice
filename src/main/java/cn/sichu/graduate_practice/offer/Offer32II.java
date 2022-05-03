package cn.sichu.graduate_practice.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * <p>
 * same: {@link cn.sichu.graduate_practice.medium.BinaryTreeLevelOrderTraversal}
 * <p>
 * similar: {@link cn.sichu.graduate_practice.offer.Offer32I}
 * 
 * @author sichu
 * @date 2022/05/03
 */
public class Offer32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
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
