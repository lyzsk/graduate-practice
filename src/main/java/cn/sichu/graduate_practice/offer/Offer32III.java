package cn.sichu.graduate_practice.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * <p>
 * similar: {@link cn.sichu.graduate_practice.offer.Offer32II}
 * 
 * @author sichu
 * @date 2022/05/03
 */
public class Offer32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.addLast(root);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();
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
            if (count % 2 != 0) {
                // Collections.reverse(level);
                reverse(level);
            }
            res.add(level);
            ++count;
        }
        return res;
    }

    private static void reverse(List<Integer> level) {
        // int left = 0;
        // int right = level.size() - 1;
        // int mid = level.size() >> 1;
        // for (int i = left, j = right; i < mid; i++, j--) {
        // swap(level, i, j);
        // }
        int left = 0;
        int right = level.size() - 1;
        while (left < right) {
            level.set(left, level.set(right, level.get(left)));
            ++left;
            --right;
        }
    }

    // private static void swap(List<Integer> level, int left, int right) {
    // level.set(left, level.set(right, level.get(left)));
    // }
}
