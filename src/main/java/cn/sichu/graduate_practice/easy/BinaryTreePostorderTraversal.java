package cn.sichu.graduate_practice.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class BinaryTreePostorderTraversal {
    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (root.left != null) {
            postorderTraversal(root.left);
        }
        if (root.right != null) {
            postorderTraversal(root.right);
        }
        res.add(root.val);

        return res;
    }
}
