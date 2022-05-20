package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode.cn/problems/increasing-order-search-tree/
 * 
 * @author sichu
 * @date 2022/05/18
 */
public class IncreasingOrderSearchTree {
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
