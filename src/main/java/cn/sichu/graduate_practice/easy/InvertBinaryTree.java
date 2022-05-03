package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * <p>
 * offer linke: {@link cn.sichu.graduate_practice.offer.Offer27}
 * 
 * @author sichu
 * @date 2022/04/03
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }

        return root;
    }
}
