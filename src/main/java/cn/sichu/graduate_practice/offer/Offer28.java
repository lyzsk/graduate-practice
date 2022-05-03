package cn.sichu.graduate_practice.offer;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/ same:
 * {@link cn.sichu.graduate_practice.easy.SymmetricTree}
 * 
 * @author sichu
 * @date 2022/05/03
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
