package cn.sichu.graduate_practice.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class BinaryTreeInorderTraversal {
    /**
     * O(n)
     * <p>
     * O(1)
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalSolution1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
    }

    /**
     * O(n)
     * <p>
     * O(n)
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalSolution2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inOrder(root.left, res);
            res.add(root.val);
            inOrder(root.right, res);
        }
    }
}
