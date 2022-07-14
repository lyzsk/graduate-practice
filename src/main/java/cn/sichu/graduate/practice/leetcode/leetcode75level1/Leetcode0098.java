package cn.sichu.graduate.practice.leetcode.leetcode75level1;

import cn.sichu.graduate.practice.codetop.utils.TreeNode;

public class Leetcode0098 {
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
