package cn.sichu.graduate_practice.offer;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/ same: same:
 * {@link cn.sichu.graduate_practice.easy.InvertBinaryTree}
 * 
 * @author sichu
 * @date 2022/05/03
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null) {
            mirrorTree(root.left);
        }
        if (root.right != null) {
            mirrorTree(root.right);
        }
        return root;
    }
}
