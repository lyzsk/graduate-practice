package cn.sichu.graduate_practice.offerii;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode.cn/problems/NYBBNL/
 * 
 * @author sichu
 * @date 2022/05/18
 */
public class OfferII052 {

    private TreeNode res;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode();
        res = dummy;
        inOrder(root);
        return dummy.right;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        res.right = node;
        node.left = null;
        res = node;
        inOrder(node.right);
    }
}
