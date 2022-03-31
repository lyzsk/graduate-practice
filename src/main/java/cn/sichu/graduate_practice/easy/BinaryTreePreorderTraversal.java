package cn.sichu.graduate_practice.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class BinaryTreePreorderTraversal {
    List<Integer> res = new ArrayList<Integer>();

    /**
     * O(n)
     * <p>
     * O(n)
     * 
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
}
