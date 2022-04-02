package cn.sichu.graduate_practice.medium;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 
 * @author sichu
 * @date 2022/04/02
 */
public class ValidateBinarySearchTree {
    long pre = Long.MIN_VALUE;

    /**
     * O(n)
     * <p>
     * O(n)
     * 
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

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
