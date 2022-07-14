package cn.sichu.graduate.practice.leetcode.leetcode75level1;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * @author sichu
 * @date 2022/07/12
 */
public class Leetcode0235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
