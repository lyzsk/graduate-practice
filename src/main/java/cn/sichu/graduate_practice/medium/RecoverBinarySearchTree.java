package cn.sichu.graduate_practice.medium;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * 
 * @author sichu
 * @date 2022/04/02
 */
public class RecoverBinarySearchTree {

    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    /**
     * O(n)
     * <p>
     * O(h)
     * 
     * @param root
     */
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inOrder(root.left);
        }

        if (firstNode == null && preNode.val > root.val) {
            firstNode = preNode;
        }
        if (firstNode != null && preNode.val > root.val) {
            secondNode = root;
        }
        preNode = root;

        if (root.right != null) {
            inOrder(root.right);
        }
    }
}
