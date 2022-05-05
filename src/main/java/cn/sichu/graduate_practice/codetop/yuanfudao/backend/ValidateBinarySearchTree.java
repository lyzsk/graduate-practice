package cn.sichu.graduate_practice.codetop.yuanfudao.backend;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * 频率4
 * <p>
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 
 * @author sichu
 * @date 2022/05/04
 */
public class ValidateBinarySearchTree {
    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }
}
