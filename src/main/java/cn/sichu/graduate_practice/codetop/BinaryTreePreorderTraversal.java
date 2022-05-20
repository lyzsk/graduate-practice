package cn.sichu.graduate_practice.codetop;

import java.util.ArrayList;
import java.util.List;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * 频率53
 * <p>
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class BinaryTreePreorderTraversal {
    private List<Integer> res = new ArrayList<Integer>();

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
