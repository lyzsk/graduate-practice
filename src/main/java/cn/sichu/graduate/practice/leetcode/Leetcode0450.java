package cn.sichu.graduate.practice.leetcode;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * root 有左右子树 可以将 root 的右子树中的最小节点，记为 successor 作为新的根节点替代 root
 * <p>
 * 并将 successor 从 root 的右子树中删除，使得在保持有序性的情况下合并左右子树。
 * 
 * @author sichu
 * @date 2022/06/02
 */
public class Leetcode0450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }
}
