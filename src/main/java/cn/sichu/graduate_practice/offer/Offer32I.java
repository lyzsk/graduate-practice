package cn.sichu.graduate_practice.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * <p>
 * similar: {@link cn.sichu.graduate_practice.medium.BinaryTreeLevelOrderTraversal}
 * <p>
 * similar: {@link cn.sichu.graduate_practice.offer.Offer32II}
 * 
 * @author sichu
 * @date 2022/05/03
 */
public class Offer32I {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.addLast(root);
        List<Integer> ans = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                ans.add(node.val);

                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
